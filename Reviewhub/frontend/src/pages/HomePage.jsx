import { useState, useEffect } from "react";
import useReviewStore from "../teachers/review";

const HomePage = () => {
    const { fetchReviews } = useReviewStore();
    const [searchQuery, setSearchQuery] = useState(""); // State for the search query
    const [reviews, setReviews] = useState([]); // Initialize reviews as an empty array
    const [hasSearched, setHasSearched] = useState(false); // Track if a search has been performed
    const [averageRating, setAverageRating] = useState(0); // State for the average rating

    const handleSearch = async (e) => {
        e.preventDefault(); // Prevent the default form submission behavior

        if (searchQuery.trim() === "") {
            alert("Please enter a teacher's name to search.");
            return;
        }

        console.log("Searching for:", searchQuery); // Debugging: Log the search query

        try {
            const response = await fetchReviews(searchQuery); // Fetch reviews for the teacher
            console.log("API response:", response); // Debugging: Log the API response

            if (response && response.success) {
                const fetchedReviews = response.data || [];
                setReviews(fetchedReviews); // Set the reviews from the `data` property

                // Calculate the average rating
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
                setReviews([]); // Clear reviews if the response is not successful
                setAverageRating(0); // Reset average rating
            }
            setHasSearched(true); // Mark that a search has been performed
        } catch (error) {
            console.error("Error during search:", error);
            alert("An error occurred while searching. Please try again later.");
        }
    };

    return (
        <div style={styles.container}>
            <h1 style={styles.heading}>Welcome to ReviewHub</h1>
            <p style={styles.subheading}>Search for teacher reviews below:</p>

            {/* Display Quote Before Search */}
            {!hasSearched && (
                <p style={styles.quote}>"Not all teachers are created equal."</p>
            )}

            {/* Display Average Rating */}
            {hasSearched && (
                <p style={styles.averageRating}>Average Big Booms: {averageRating} / 5</p>
            )}

            {/* Centered Search Bar */}
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

            {/* Display Reviews */}
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
        width: "100%", // Make all reviews take the full width of the container
        maxWidth: "600px", // Set a maximum width for each review
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
