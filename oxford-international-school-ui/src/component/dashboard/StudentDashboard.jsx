import React from 'react';
import styles from './Dashboard.module.css';
import { FaCalendarPlus, FaCalendarCheck, FaFileInvoice } from 'react-icons/fa';

const StudentDashboard = () => {
    return (
        <div className={styles.dashboard}>
            <h2>Student Dashboard</h2>
            <p>Manage your attendance and fees.</p>
            <div className={styles.featureGrid}>
                <div className={styles.featureCard}>
                    <FaCalendarPlus className={styles.icon} />
                    <span>Request Leave</span>
                </div>
                <div className={styles.featureCard}>
                    <FaCalendarCheck className={styles.icon} />
                    <span>View Attendance</span>
                </div>
                <div className={styles.featureCard}>
                    <FaFileInvoice className={styles.icon} />
                    <span>Fee Management</span>
                </div>
            </div>
        </div>
    );
};

export default StudentDashboard;
