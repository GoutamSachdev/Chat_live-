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
![Chat Screen]![image](https://github.com/GoutamSachdev/Chat_live-/assets/142876027/638cd34d-7a91-421c-a3ef-0265971f87fe)
![image](https://github.com/GoutamSachdev/Chat_live-/assets/142876027/ceed9e02-caea-446e-b79d-8490944d1ed7)



### Status Screen
![image](https://github.com/GoutamSachdev/Chat_live-/assets/142876027/eacfc52e-ebf6-4e6f-bf36-e688f08f028b)

![Status Screen]![image](https://github.com/GoutamSachdev/Chat_live-/assets/142876027/b3a55960-12d8-4662-95d1-e92535aa2351)


### Profile Screen
![Profile Screen]![image](https://github.com/GoutamSachdev/Chat_live-/assets/142876027/0305ed90-f59e-4a5a-b388-95fde61cbc57)
<img width="728" alt="image" src="https://github.com/GoutamSachdev/Chat_live-/assets/142876027/fd7177f6-6b4b-493c-b1d8-32b7ff116d36">
<img width="638" alt="image" src="https://github.com/GoutamSachdev/Chat_live-/assets/142876027/b62d8d2e-f1c7-4cf0-984d-f44937819fca">



## Technical Stack
- **Frontend**: Jetpack Compose
- **Backend**: Firebase
  - Firebase Authentication
  - Firebase Firestore
  - Firebase Storage
- **Push Notifications**: Firebase Cloud Messaging

## Project Setup
To get started with this project, follow the steps below:
### Contributing
Contributions are welcome! Please fork this repository and submit a pull request.[ git clone    https://github.com/GoutamSachdev/Chat_live-]
### Contact
If you have any questions or feedback, feel free to reach out to me at gksachdev46@gmail.com.


1. **Clone the repository**:
    ```sh
    git clone git remote add origin https://github.com/GoutamSachdev/Chat_live-.git
    cd Chat_live
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


