import express from "express";
import dotenv from "dotenv";
import path from "path";
import { connectDB } from "./config/db.js";
import productsRoutes from "./routes/products.route.js";

dotenv.config();

const app = express();

const __dirname = path.resolve();

app.use(express.json());

app.use("/api", productsRoutes);

if (process.env.NODE_ENV === "production") {
    app.use(express.static(path.join(__dirname, "/frontend/dist")));

    app.get(/^\/(?!api).*/, (req, res) => {
        res.sendFile(path.resolve(__dirname, "frontend", "dist", "index.html"));
    });
}

function logRoutes(app) {
    console.log("Registered Routes:");
    app._router?.stack.forEach((middleware) => {
        if (middleware.route) {
            console.log(`Route: ${middleware.route.path}`);
        } else if (middleware.name === "router") {
            middleware.handle.stack.forEach((handler) => {
                if (handler.route) {
                    console.log(`Nested Route: ${handler.route.path}`);
                }
            });
        }
    });
}
logRoutes(app);

app.listen(8632, () => {
    connectDB();
    console.log("Server started at http://localhost:" + 8632);
});
