import React from 'react';
import styles from './Dashboard.module.css';
import { FaUsersCog, FaShieldAlt, FaMoneyBillWave, FaUserGraduate, FaChalkboardTeacher, FaChartLine } from 'react-icons/fa';

const SuperuserDashboard = () => {
    return (
        <div className={styles.dashboard}>
            <h2>Superuser Dashboard</h2>
            <p>You have access to all features.</p>
            <div className={styles.featureGrid}>
                <div className={styles.featureCard}>
                    <FaUsersCog className={styles.icon} />
                    <span>User Management</span>
                </div>
                <div className={styles.featureCard}>
                    <FaShieldAlt className={styles.icon} />
                    <span>System Settings</span>
                </div>
                <div className={styles.featureCard}>
                    <FaMoneyBillWave className={styles.icon} />
                    <span>Full Payroll Access</span>
                </div>
                <div className={styles.featureCard}>
                    <FaUserGraduate className={styles.icon} />
                    <span>All Student Data</span>
                </div>
                <div className={styles.featureCard}>
                    <FaChalkboardTeacher className={styles.icon} />
                    <span>All Teacher Data</span>
                </div>
                <div className={styles.featureCard}>
                    <FaChartLine className={styles.icon} />
                    <span>Analytics & Reporting</span>
                </div>
            </div>
        </div>
    );
};

export default SuperuserDashboard;
