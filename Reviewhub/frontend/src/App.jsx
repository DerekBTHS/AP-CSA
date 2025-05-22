import { Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="">
      <Routes>
        <Route path="/" element={<h1>Home</h1>} />
        <Route path="/:teacher" element={<h1>Teacher Reviews</h1>} />
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </div>
  )
}

export default App;