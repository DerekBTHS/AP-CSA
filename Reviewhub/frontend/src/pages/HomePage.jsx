import { useState, useEffect } from "react";
import useReviewStore from "../teachers/review";

const HomePage = () => {
    const { fetchReviews } = useReviewStore();
    const [searchQuery, setSearchQuery] = useState("");
    const [reviews, setReviews] = useState([]);
    const [hasSearched, setHasSearched] = useState(false);
    const [averageRating, setAverageRating] = useState(0);

    const handleSearch = async (e) => {
        e.preventDefault();

        if (searchQuery.trim() === "") {
            alert("Please enter a teacher's name to search.");
            return;
        }

        console.log("Searching for:", searchQuery);

        try {
            const response = await fetchReviews(searchQuery);
            console.log("API response:", response);

            if (response && response.success) {
                const fetchedReviews = response.data || [];
                setReviews(fetchedReviews);

                const totalRating = fetchedReviews.reduce(
                    (sum, review) => sum + review.rating,
                    0
                );
                const avgRating =
                    fetchedReviews.length > 0
                        ? (totalRating / fetchedReviews.length).toFixed(1)
                        : 0;
                setAverageRating(avgRating);
            } else {
                setReviews([]);
                setAverageRating(0);
            }
            setHasSearched(true);
        } catch (error) {
            console.error("Error during search:", error);
            alert("An error occurred while searching. Please try again later.");
        }
    };

    return (
        <div style={styles.container}>
            <h1 style={styles.heading}>Welcome to ReviewHub</h1>
            <p style={styles.subheading}>Search for teacher reviews below:</p>

            {!hasSearched && (
                <p style={styles.quote}>"Not all teachers are created equal."</p>
            )}

            {hasSearched && (
                <p style={styles.averageRating}>Average Big Booms: {averageRating} / 5</p>
            )}

            <form onSubmit={handleSearch} style={styles.searchBarContainer}>
                <input
                    type="text"
                    placeholder="Enter teacher's name"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                    style={styles.input}
                />
                <button type="submit" style={styles.button}>
                    🔍
                </button>
            </form>

            <div style={styles.reviewsContainer}>
                {Array.isArray(reviews) && reviews.length > 0
                    ? reviews.map((review, index) => (
                          <div key={index} style={styles.reviewCard}>
                              <p style={styles.reviewContent}>{review.content}</p>
                              <p style={styles.reviewRating}>
                                  Big Booms: {review.rating} / 5
                              </p>
                          </div>
                      ))
                    : hasSearched && (
                          <p style={styles.noReviews}>
                              No reviews found. Try searching for a teacher.
                          </p>
                      )}
            </div>
        </div>
    );
};

const styles = {
    container: {
        minHeight: "100vh",
        backgroundColor: "#2C363F",
        padding: "32px",
    },
    heading: {
        fontSize: "3rem",
        fontWeight: "bold",
        marginBottom: "16px",
        textAlign: "center",
    },
    subheading: {
        fontSize: "1.5rem",
        marginBottom: "24px",
        textAlign: "center",
    },
    quote: {
        fontSize: "1.25rem",
        fontStyle: "italic",
        color: "#7F95D1",
        marginBottom: "24px",
        textAlign: "center",
    },
    averageRating: {
        fontSize: "1.5rem",
        fontWeight: "bold",
        color: "#7F95D1",
        marginBottom: "24px",
        textAlign: "center",
    },
    searchBarContainer: {
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        marginBottom: "32px",
    },
    input: {
        padding: "16px",
        fontSize: "1.25rem",
        border: "1px solid #d1d5db",
        borderRadius: "8px 0 0 8px",
        width: "300px",
        outline: "none",
    },
    button: {
        padding: "16px",
        fontSize: "1.25rem",
        backgroundColor: "#3b82f6",
        color: "#ffffff",
        border: "none",
        borderRadius: "0 8px 8px 0",
        cursor: "pointer",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
    },
    reviewsContainer: {
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        width: "100%",
        maxWidth: "800px",
        margin: "0 auto",
    },
    reviewCard: {
        width: "100%",
        maxWidth: "600px",
        padding: "24px",
        marginBottom: "16px",
        backgroundColor: "#ffffff",
        borderRadius: "8px",
        boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)",
        border: "1px solid #e5e7eb",
    },
    reviewContent: {
        fontSize: "1.25rem",
        marginBottom: "8px",
        color: "#374151",
    },
    reviewRating: {
        fontSize: "1.25rem",
        fontWeight: "bold",
        color: "#f59e0b",
    },
    noReviews: {
        fontSize: "1.25rem",
        textAlign: "center",
        color: "#6b7280",
    },
};

export default HomePage;
