import React from 'react';
import { useAuth } from '../context/AuthContext';
import SuperuserDashboard from '../component/dashboard/SuperuserDashboard';
import AdminDashboard from '../component/dashboard/AdminDashboard';
import TeacherDashboard from '../component/dashboard/TeacherDashboard';
import StudentDashboard from '../component/dashboard/StudentDashboard';
import styles from './DashboardPage.module.css';
import { FaTachometerAlt, FaUsers, FaCog, FaSignOutAlt } from 'react-icons/fa';

const DashboardPage = () => {
    const { user, logout } = useAuth();

    const renderDashboardByRole = () => {
        const role = user?.role.toLowerCase();

        switch (role) {
            case 'superuser':
                return <SuperuserDashboard />;
            case 'admin':
                return <AdminDashboard />;
            case 'teacher':
                return <TeacherDashboard />;
            case 'student':
                return <StudentDashboard />;
            default:
                return <p>No specific dashboard available for your role. You may need to log in again.</p>;
        }
    };

    return (
        <div className={styles.dashboardLayout}>
            <aside className={styles.sidebar}>
                <div className={styles.sidebarHeader}>
                    <h3>Dashboard</h3>
                </div>
                <nav className={styles.sidebarNav}>
                    <a href="#/" className={styles.navLink}><FaTachometerAlt /><span>Overview</span></a>
                    <a href="#/" className={styles.navLink}><FaUsers /><span>Profile</span></a>
                    <a href="#/" className={styles.navLink}><FaCog /><span>Settings</span></a>
                </nav>
                <div className={styles.sidebarFooter}>
                    <button onClick={logout} className={styles.logoutButton}><FaSignOutAlt /><span>Logout</span></button>
                </div>
            </aside>
            <div className={styles.dashboardContainer}>
                <header className={styles.header}>
                    <h1>Welcome, {user?.username || 'User'}!</h1>
                    <p>Here's your overview for today.</p>
                </header>
                <main className={styles.mainContent}>
                    {renderDashboardByRole()}
                </main>
            </div>
        </div>
    );
};

export default DashboardPage;
