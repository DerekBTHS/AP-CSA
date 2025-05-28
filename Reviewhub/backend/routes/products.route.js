import express from "express";
import mongoose from "mongoose";
import { getReviewModelForTeacher } from "../models/dynamicReview.model.js";

const router = express.Router();

router.get("/:teacher", async (req, res) => {
    const teacherName = req.params.teacher;

    if (!teacherName) {
        return res
            .status(400)
            .json({ success: false, message: "Teacher name is required" });
    }

    try {
        const ReviewModel = getReviewModelForTeacher(teacherName);
        const reviews = await ReviewModel.find();
        res.status(200).json({ success: true, data: reviews });
    } catch (error) {
        console.error("Error fetching reviews:", error.message);
        res.status(500).json({ success: false, message: error.message });
    }
});

router.post("/:teacher", async (req, res) => {
    const teacherName = req.params.teacher;
    const review = req.body;

    if (!teacherName) {
        return res
            .status(400)
            .json({ success: false, message: "Teacher name is required" });
    }

    if (!review.content || !review.rating) {
        return res
            .status(400)
            .json({ success: false, message: "All fields are required" });
    }

    try {
        const ReviewModel = getReviewModelForTeacher(teacherName);
        const newReview = new ReviewModel(review);
        await newReview.save();
        res.status(201).json({ success: true, data: newReview });
    } catch (error) {
        console.error("Error saving review:", error.message);
        res.status(500).json({ success: false, message: error.message });
    }
});

export default router;
