import React from 'react';
import { Routes, Route, useLocation } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import HomePage from './pages/HomePage';
import DashboardPage from './pages/DashboardPage';
import Header from './component/Header';
import PrivateRoute from './component/PrivateRoute';
import './App.css';

function App() {
    const location = useLocation();
    const hideHeader = location.pathname.startsWith('/dashboard');

    return (
        <div className="App">
            {!hideHeader && <Header />}
            <main>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/signup" element={<SignupPage />} />
                    <Route 
                        path="/dashboard" 
                        element={
                            <PrivateRoute>
                                <DashboardPage />
                            </PrivateRoute>
                        } 
                    />
                </Routes>
            </main>
        </div>
    );
}export default App;
