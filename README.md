# Chat_Live Application with Status Feature

This project is a real-time chat application built using Jetpack Compose for the UI and Firebase for backend services. Users can send and receive messages in real-time, upload and view status images, and manage their profile information.

## Features
- **Real-time Chat**: Send and receive messages in real-time.
- **User Authentication**: 
  - Email/Password login and registration.
  - Google Sign-In integration.
- **Login Form**: User-friendly login interface.
- **Status Sharing**: Upload and view status images that expire after 24 hours.
- **Profile Management**: Update name and profile picture.
- **Password Reset**: Reset password via email.
- **Push Notifications**: Receive notifications for new messages and status updates.

## Screenshots
### Chat Screen
![Chat Screen](images/chat_screen.png)

### Status Screen
![Status Screen](images/status_screen.png)

### Profile Screen
![Profile Screen](images/profile_screen.png)

## Technical Stack
- **Frontend**: Jetpack Compose
- **Backend**: Firebase
  - Firebase Authentication
  - Firebase Firestore
  - Firebase Storage
- **Push Notifications**: Firebase Cloud Messaging

## Project Setup
To get started with this project, follow the steps below:

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/chat-app.git
    cd chat-app
    ```

2. **Build the project**:
    ```sh
    ./gradlew build
    ```

3. **Run the project**:
    ```sh
    ./gradlew run
    ```

## Firebase Configuration
To configure Firebase for this project, follow these steps:

1. **Create a Firebase project**:
   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Click on "Add project" and follow the instructions.

2. **Add an Android app to your Firebase project**:
   - Register your app with the package name `com.yourcompany.chatapp`.
   - Download the `google-services.json` file.

3. **Add `google-services.json` to your project**:
   - Place the `google-services.json` file in the `app` directory of your project.

4. **Add Firebase SDK dependencies**:
   - Open your `build.gradle` files and add the necessary dependencies for Firebase Authentication, Firestore, and Storage.

## Usage
Once the project is set up, you can use the following features:

### User Authentication
```kotlin
FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // Sign in success
            val user = FirebaseAuth.getInstance().currentUser
        } else {
            // If sign in fails
            Log.w(TAG, "signInWithEmail:failure", task.exception)
        }
    }
