import { create } from "zustand";

const useReviewStore = create((set) => ({
    reviews: [],
    setReviews: (reviews) => set({ reviews }),
    createReview: async (teacherName, newReview) => {
        if (!newReview.content || !newReview.rating) {
            return { success: false, message: "All fields are required" };
        }
        try {
            const res = await fetch(`/api/${teacherName}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(newReview),
            });

            const data = await res.json();

            // Correctly update the reviews array in the state
            set((state) => ({
                reviews: [...state.reviews, data.data],
            }));

            return { success: true, message: "Review created successfully" };
        } catch (error) {
            console.error("Error creating review:", error);
            return { success: false, message: "Failed to create review" };
        }
    },
    fetchReviews: async (teacherName) => {
        try {
            const res = await fetch(`/api/${teacherName}`);
            if (!res.ok) {
                throw new Error(`Failed to fetch reviews: ${res.statusText}`);
            }
            const data = await res.json();
            console.log("API response:", data); // Debugging: Log the API response
            return data; // Return the full response object
        } catch (error) {
            console.error("Error fetching reviews:", error);
            return { success: false, data: [] }; // Return a consistent structure
        }
    },
}));

export default useReviewStore;
