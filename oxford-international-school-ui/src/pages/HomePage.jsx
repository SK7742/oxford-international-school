import React from 'react';
import styles from './HomePage.module.css';
import ImageSlider from '../component/ImageSlider';

const HomePage = () => {
    return (
        <div className={styles.homePage}>
            <ImageSlider />

            <section id="about" className={`${styles.section} ${styles.aboutSection}`}>
                <div className={styles.sectionContent}>
                    <h2>About Us</h2>
                    <p>
                        Oxford International School, situated on Sainik Road, Harpur, is a premier educational institution dedicated to providing a nurturing and stimulating environment for young learners from Nursery to the 5th class.
                    </p>
                </div>
            </section>

            <section id="director" className={`${styles.section} ${styles.directorSection}`}>
                <div className={styles.sectionContent}>
                    <h2>From the Director's Desk</h2>
                    <div className={styles.directorInfo}>
                        <p>
                            Our school is managed and directed by <strong>Mr. Anil Kumar Gupta</strong>, a visionary with over 18 years of IT experience with top-notch companies. His passion is to blend modern technology with foundational learning to prepare students for a bright future.
                        </p>
                        <h3>Our Vision</h3>
                        <p>
                            To make quality education accessible and affordable for everyone. We are committed to providing the highest standard of education at a low cost, ensuring every child has the opportunity to succeed.
                        </p>
                    </div>
                </div>
            </section>

            <section id="academics" className={`${styles.section} ${styles.academicsSection}`}>
                <div className={styles.sectionContent}>
                    <h2>Academics</h2>
                    <p>Our curriculum is designed to foster creativity, critical thinking, and a lifelong love for learning. We offer classes for:</p>
                    <div className={styles.cardContainer}>
                        <div className={styles.card}>Nursery</div>
                        <div className={styles.card}>LKG & UKG</div>
                        <div className={styles.card}>Class 1</div>
                        <div className={styles.card}>Class 2</div>
                        <div className={styles.card}>Class 3</div>
                        <div className={styles.card}>Class 4</div>
                        <div className={styles.card}>Class 5</div>
                    </div>
                </div>
            </section>

            <section id="contact" className={`${styles.section} ${styles.contactSection}`}>
                <div className={styles.sectionContent}>
                    <h2>Contact Us</h2>
                    <p>We would love to hear from you. Visit us at:</p>
                    <p><strong>Oxford International School</strong><br/>
                    Sainik Road, Harpur</p>
                </div>
            </section>
        </div>
    );
};

export default HomePage;
