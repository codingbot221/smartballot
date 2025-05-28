# 🗳️ SmartBallot

## 1. Project Title

**SmartBallot** – A secure mobile-based voting system for student bodies and small organizations.

---

## 2. Project Description

**SmartBallot** is an Android application built using Java and Firebase that aims to digitize and simplify the traditional voting process. Designed for use in student elections, club polls, and community decisions, it provides a seamless experience for both voters and administrators. It ensures **one-person-one-vote**, real-time result tracking, and a user-friendly mobile interface.

**Key Features:**
- Firebase-based Authentication (Sign Up/Login)
- Realtime voting with database sync
- Secure, single-vote enforcement
- Admin election and candidate setup
- Live results dashboard

---

## 3. Installation Instructions

Follow these steps to set up and run the SmartBallot app on your local machine:

### Prerequisites
- Android Studio
- Firebase Account
- Android Emulator or Physical Device (with USB debugging)

### Setup
git clone https://github.com/codingbot221/smartballot.git
cd smartballot
## 1. Open Project in Android Studio

File > Open > Select the cloned project folder

## 2.Firebase Setup

- to Firebase Console, create a new project

- Enable Email/Password Authentication

- Set up Realtime Database, use rules like:

  json
 {
    "rules": {
    ".read": "auth != null",
    ".write": "auth != null"
  }
}
- Download google-services.json from Firebase > Project Settings

- Place it in the /app/ directory of the project

## 3.Build the App

- Let Gradle sync automatically

- Connect an emulator or physical device

- Click Run ▶️ or press Shift + F10

## 4. Usage Examples
### 👤 User Flow
Launch the app

- Sign up with a valid email and password

- Log in using the same credentials

- View available elections and cast your vote

- Check real-time election results

### 🛠 Admin Flow
- Sign in using admin credentials (you can define admin role in Firebase)

- Create elections and add candidate details

- Monitor votes and control access

### 🎥 Demo
You can watch a demo video (upload your .mov to the repo and replace this link)

### 5. Contribution Guidelines
We welcome contributions to make SmartBallot better! To contribute:

- 1.Fork the repository

- 2.Create a new branch (git checkout -b feature-name)

- 3.Commit your changes (git commit -m 'Add new feature')

- 4.Push to your forked repo (git push origin feature-name)

- 5.Open a Pull Request

### Coding Standards
- Use meaningful variable/method names

- Stick to Java conventions

- Document public methods/classes using Javadoc

### Testing
Test your features on both emulator and physical device

Make sure Firebase integration is functional before submitting

## 6. License Information
This project is licensed under the MIT License.
Feel free to use, modify, and distribute it with attribution.

### Author: Garikapati Aishwarya
### GitHub: @codingbot221

https://github.com/user-attachments/assets/b8a63c1f-cd77-4824-9181-79ffdf98a60b

