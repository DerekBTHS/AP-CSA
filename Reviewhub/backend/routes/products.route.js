import express from "express";
import mongoose from "mongoose";
import { getReviewModelForTeacher} from '../models/dynamicReview.model.js';

const router = express.Router();

router.get("/:teacher", async (req, res) => {
    const teacherName = req.params.teacher;

    try {
        const ReviewModel = getReviewModelForTeacher(teacherName);
        const reviews = await ReviewModel.find();
        res.status(200).json({ success: true, data: reviews });
    } catch (error) {
        res.status(500).json({ success: false, message: error.message });
    }
});

router.post("/:teacher", async (req, res) => {
    const teacherName = req.params.teacher;
    const review = req.body;

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
        res.status(500).json({ success: false, message: error.message });
    }
});

export default router;
