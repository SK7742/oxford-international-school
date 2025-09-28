import React from 'react';
import Slider from 'react-slick';
import styles from './ImageSlider.module.css';

const ImageSlider = () => {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        fade: true,
        cssEase: 'linear'
    };

    const images = [
        {
            src: 'https://images.unsplash.com/photo-1580582932707-520aed937c7c?q=80&w=2070&auto=format&fit=crop',
            alt: 'School building',
            caption: 'Welcome to Oxford International School'
        },
        {
            src: 'https://images.unsplash.com/photo-1523050854058-8df90110c9f1?q=80&w=2070&auto=format&fit=crop',
            alt: 'Students in a classroom',
            caption: 'Nurturing Future Leaders'
        },
        {
            src: 'https://images.unsplash.com/photo-1524178232363-1fb2b075b655?q=80&w=2070&auto=format&fit=crop',
            alt: 'A teacher with students',
            caption: 'Quality Education for All'
        }
    ];

    return (
        <div className={styles.sliderContainer}>
            <Slider {...settings}>
                {images.map((image, index) => (
                    <div key={index} className={styles.slide}>
                        <img src={image.src} alt={image.alt} className={styles.sliderImage} />
                        <div className={styles.caption}>
                            <h2>{image.caption}</h2>
                        </div>
                    </div>
                ))}
            </Slider>
        </div>
    );
};

export default ImageSlider;
