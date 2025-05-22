import mongoose from "mongoose";

export const getReviewModelForTeacher = (teacherName) => {
    const collectionName = teacherName.replace(/\s+/g, "_").toLowerCase();
    if (mongoose.models[collectionName]) {
        return mongoose.models[collectionName];
    }
    const reviewSchema = new mongoose.Schema(
        {
            content: {
                type: String,
                required: true,
            },
            rating: {
                type: Number,
                required: true,
                min: 1,
                max: 5,
                validate: {
                    validator: Number.isInteger,
                    message: "{VALUE} is not an integer value",
                },
            },
        },
        { versionKey: false }
    );
    return mongoose.model(collectionName, reviewSchema, collectionName);
};