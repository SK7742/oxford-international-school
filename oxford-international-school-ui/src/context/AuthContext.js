import React, { createContext, useState, useContext } from 'react';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    // For demonstration, we'll start with a mock user.
    // In a real app, you'd initialize this from localStorage or an API call.
    const [user, setUser] = useState(null);

    const login = (userData) => {
        setUser(userData);
        console.log("Logged in user:", userData.username);
    };

    const logout = () => {
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    return useContext(AuthContext);
};
