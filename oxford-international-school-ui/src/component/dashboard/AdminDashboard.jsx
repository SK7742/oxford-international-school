import React from 'react';
import styles from './Dashboard.module.css';
import { FaChalkboardTeacher, FaUserGraduate, FaFileInvoiceDollar } from 'react-icons/fa';

const AdminDashboard = () => {
    return (
        <div className={styles.dashboard}>
            <h2>Admin Dashboard</h2>
            <p>Manage teachers, students, and payroll.</p>
            <div className={styles.featureGrid}>
                <div className={styles.featureCard}>
                    <FaChalkboardTeacher className={styles.icon} />
                    <span>Manage Teachers</span>
                </div>
                <div className={styles.featureCard}>
                    <FaUserGraduate className={styles.icon} />
                    <span>Manage Students</span>
                </div>
                <div className={styles.featureCard}>
                    <FaFileInvoiceDollar className={styles.icon} />
                    <span>Manage Payroll</span>
                </div>
            </div>
        </div>
    );
};

export default AdminDashboard;
