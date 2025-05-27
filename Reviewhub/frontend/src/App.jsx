import { Route, Routes } from "react-router-dom";
import CreatePage from "./pages/CreatePage";
import HomePage from "./pages/HomePage"
import Navbar from "./components/Navbar";

function App() {
    return (
        <div className="">
            <Navbar />
            <Routes>
                <Route path="/" element={<HomePage/>} />
                <Route path="/create" element={<CreatePage/>} />
                <Route path="*" element={<h1>404 Not Found</h1>} />
            </Routes>
        </div>
    );
}

export default App;