import React from 'react';
import styles from './Dashboard.module.css';
import { FaUsers, FaMoneyCheckAlt } from 'react-icons/fa';

const TeacherDashboard = () => {
    return (
        <div className={styles.dashboard}>
            <h2>Teacher Dashboard</h2>
            <p>Access your student and payroll information.</p>
            <div className={styles.featureGrid}>
                <div className={styles.featureCard}>
                    <FaUsers className={styles.icon} />
                    <span>Student Management</span>
                </div>
                <div className={styles.featureCard}>
                    <FaMoneyCheckAlt className={styles.icon} />
                    <span>View My Payroll</span>
                </div>
            </div>
        </div>
    );
};

export default TeacherDashboard;
