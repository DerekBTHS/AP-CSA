import { Link } from "react-router-dom";
import Logo from "../assets/Logo.png";

const Navbar = () => {
    return (
        <nav style={styles.navbar}>
            <div style={styles.logo}>
                <Link to="/">
                    <img
                        src={Logo}
                        alt="ReviewHub Logo"
                        style={styles.logoImage}
                    />
                </Link>
            </div>
            <ul style={styles.navLinks}>
                <li>
                    <Link to="/create" style={styles.link}>
                        Create Review
                    </Link>
                </li>
            </ul>
        </nav>
    );
};

const styles = {
    navbar: {
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        padding: "10px 50px",
        backgroundColor: "#2C363F",
        color: "#F2F5EA",
    },
    logo: {
        fontSize: "1.5rem",
        fontWeight: "bold",
    },
    logoImage: {
        height: "80px",
        transform: "translateY(0.4rem)",
    },
    navLinks: {
        listStyle: "none",
        display: "flex",
        gap: "15px",
    },
    link: {
        textDecoration: "none",
        color: "#F2F5EA",
        fontSize: "2.5rem",
        fontWeight: "bold",
    },
};

export default Navbar;
