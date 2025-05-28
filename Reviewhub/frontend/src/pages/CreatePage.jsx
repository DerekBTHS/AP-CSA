import { useState } from "react";
import useReviewStore from "../teachers/review";

const CreatePage = () => {
    const [newReview, setNewReview] = useState({
        content: "",
        rating: 1,
    });
    const [teacherName, setTeacherName] = useState("");
    const [toast, setToast] = useState({ message: "", type: "", visible: false });

    const { createReview } = useReviewStore();

    const handleAddReview = async (e) => {
        e.preventDefault();
        const { success, message } = await createReview(teacherName, newReview);

        if (success) {
            showToast("Review submitted successfully!", "success");
            setTeacherName("");
            setNewReview({ content: "", rating: 1 });
        } else {
            showToast(`Failed to submit review: ${message}`, "error");
        }
    };

    const handleBoomClick = (rating) => {
        setNewReview({ ...newReview, rating });
    };

    const showToast = (message, type) => {
        setToast({ message, type, visible: true });
        setTimeout(() => {
            setToast({ ...toast, visible: false });
        }, 3000);
    };

    return (
        <div style={styles.container}>
            {toast.visible && (
                <div
                    style={{
                        ...styles.toast,
                        ...(toast.type === "success"
                            ? styles.toastSuccess
                            : styles.toastError),
                    }}
                >
                    {toast.message}
                </div>
            )}
            <h1 style={styles.heading}>Create a New Review</h1>
            <form onSubmit={handleAddReview} style={styles.form}>
                <label style={styles.label}>
                    Teacher Name
                    <input
                        type="text"
                        value={teacherName}
                        onChange={(e) => setTeacherName(e.target.value)}
                        style={styles.input}
                        required
                    />
                </label>
                <label style={styles.label}>
                    Review
                    <textarea
                        value={newReview.content}
                        onChange={(e) =>
                            setNewReview({ ...newReview, content: e.target.value })
                        }
                        style={styles.textarea}
                        required
                    />
                </label>
                <label style={styles.label}>
                    Big Booms
                    <div style={styles.booms}>
                        {[1, 2, 3, 4, 5].map((boom) => (
                            <span
                                key={boom}
                                onClick={() => handleBoomClick(boom)}
                                style={{
                                    ...styles.boom,
                                    color:
                                        newReview.rating >= boom ? "#FFD700" : "#7F95D1",
                                    textShadow:
                                        newReview.rating >= boom
                                            ? "0 0 10px #FFD700"
                                            : "none",
                                }}
                            >
                                💥
                            </span>
                        ))}
                    </div>
                </label>
                <button type="submit" style={styles.button}>
                    Submit Review
                </button>
            </form>
        </div>
    );
};

const styles = {
    container: {
        maxWidth: "600px",
        margin: "auto auto",
        padding: "20px",
        backgroundColor: "#2C363F",
        borderRadius: "8px",
        color: "#F2F5EA",
        position: "relative",
    },
    heading: {
        textAlign: "center",
        color: "#F2F5EA",
    },
    form: {
        display: "flex",
        flexDirection: "column",
        gap: "15px",
    },
    label: {
        fontSize: "1.5rem",
        fontWeight: "bold",
        marginBottom: "5px",
        color: "#F2F5EA",
    },
    input: {
        padding: "10px",
        fontSize: "1rem",
        border: "1px solid #7F95D1",
        borderRadius: "4px",
        width: "100%",
        backgroundColor: "#F2F5EA",
        color: "#2C363F",
        marginBottom: "15px",
    },
    textarea: {
        padding: "10px",
        fontSize: "1rem",
        border: "1px solid #7F95D1",
        borderRadius: "4px",
        width: "100%",
        height: "100px",
        backgroundColor: "#F2F5EA",
        color: "#2C363F",
        resize: "none",
        marginBottom: "15px",
    },
    booms: {
        display: "flex",
        justifyContent: "center",
        gap: "10px",
        marginTop: "10px",
    },
    boom: {
        fontSize: "3rem",
        cursor: "pointer",
        transition: "color 0.3s, text-shadow 0.3s",
    },
    button: {
        padding: "10px 20px",
        fontSize: "1rem",
        fontWeight: "bold",
        color: "#F2F5EA",
        backgroundColor: "#E75A7C",
        border: "none",
        borderRadius: "4px",
        cursor: "pointer",
        transition: "background-color 0.3s",
        width: "100%",
    },
    toast: {
        position: "fixed",
        top: "20px",
        left: "50%",
        transform: "translateX(-50%)",
        padding: "10px 20px",
        borderRadius: "5px",
        fontSize: "1rem",
        fontWeight: "bold",
        zIndex: 1000,
        color: "#fff",
        textAlign: "center",
        boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)",
    },
    toastSuccess: {
        backgroundColor: "#4CAF50",
    },
    toastError: {
        backgroundColor: "#F44336",
    },
};

export default CreatePage;
