import express from 'express';
import dotenv from 'dotenv';
import { connectDB } from './config/db.js';
import productsRoutes from './routes/products.route.js';

dotenv.config();

const app = express();

app.use(express.json());

app.use("/api", productsRoutes);

app.listen(PORT, () => {
    connectDB();
    console.log("Server started at http://localhost:" + PORT);
});