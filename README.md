<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat_Live Application with Status Feature - README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 90%;
            max-width: 800px;
            margin: auto;
            overflow: hidden;
            padding: 2rem;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2, h3 {
            color: #333;
            text-align: center;
        }
        ul {
            list-style-type: disc;
            padding-left: 20px;
        }
        img {
            display: block;
            margin: 20px auto;
            max-width: 100%;
            height: auto;
        }
        pre {
            background: #f4f4f4;
            padding: 10px;
            border: 1px solid #ddd;
            overflow-x: auto;
        }
        code {
            color: #d63384;
        }
        .btn {
            display: block;
            width: max-content;
            margin: 20px auto;
            padding: 10px 20px;
            background: #007bff;
            color: #fff;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Chat_Live Application with Status Feature</h1>
        <p>This project is a real-time chat application built using Jetpack Compose for the UI and Firebase for backend services. Users can send and receive messages in real-time, upload and view status images, and manage their profile information.</p>

        <h2>Features</h2>
        <ul>
            <li>Real-time chat</li>
            <li>User authentication (Email/Password, Google Sign-In)</li>
            <li>Login Form </li>
            <li>Status sharing (24-hour expiration)</li>
            <li>Profile management (update name and picture)</li>
            <li>Password reset via email</li>
            <li>Push notifications for new messages and status updates</li>
        </ul>

        <img src="images/chat_screen.png" alt="Chat Screen">
        <img src="images/status_screen.png" alt="Status Screen">
        <img src="images/profile_screen.png" alt="Profile Screen">

        <h2>Technical Stack</h2>
        <ul>
            <li>Frontend: Jetpack Compose</li>
            <li>Backend: Firebase (Authentication, Firestore, Storage)</li>
            <li>Push Notifications: Firebase Cloud Messaging</li>
        </ul>

        <h2>Project Setup</h2>
        <p>To get started with this project, follow the steps below:</p>
        <pre><code>git clone https://github.com/yourusername/chat-app.git
cd chat-app
./gradlew build
./gradlew run</code></pre>

        <h2>Firebase Configuration</h2>
        <p>To configure Firebase, follow these steps:</p>
        <ol>
            <li>Go to the Firebase Console and create a new project.</li>
            <li>Add an Android app to your project and download the <code>google-services.json</code> file.</li>
            <li>Place the <code>google-services.json</code> file in the <code>app</code> directory of your project.</li>
            <li>Add the Firebase SDK dependencies to your <code>build.gradle</code> files.</li>
        </ol>

        <h2>Usage</h2>
        <p>Once the project is set up, you can use the following features:</p>
        <h3>User Authentication</h3>
        <pre><code>FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // Sign in success
        } else {
            // If sign in fails
        }
    }</code></pre>

        <h3>Real-time Chat</h3>
        <pre><code>val db = FirebaseFirestore.getInstance()
val chatRef = db.collection("chats")
chatRef.addSnapshotListener { snapshots, e ->
    if (e != null) {
        return@addSnapshotListener
    }
    for (doc in snapshots!!) {
        // Handle the new chat messages
    }
}</code></pre>

        <h3>Status Feature</h3>
        <pre><code>val storageRef = FirebaseStorage.getInstance().reference
val statusRef = storageRef.child("status/${userId}.jpg")
val uploadTask = statusRef.putFile(statusUri)

uploadTask.addOnSuccessListener {
    // Handle successful upload
}.addOnFailureListener {
    // Handle failed upload
}</code></pre>

        <h3>Profile Management</h3>
        <pre><code>val userRef = db.collection("users").document(userId)
userRef.update("name", newName)
userRef.update("profilePicture", newProfilePictureUrl)</code></pre>

        <h2>Contributing</h2>
        <p>Contributions are welcome! Please fork this repository and submit a pull request.</p>
        <a href="git remote add origin https://github.com/GoutamSachdev/Chat_live-.git" class="btn">Fork on GitHub</a>

        <h2>License</h2>
        <p>This project is licensed under the @goutamSachdev License. file for more details.</p>

        <h2>Contact</h2>
        <p>If you have any questions or feedback, feel free to reach out to me at <a href="mailto:gksachdev46@gmail.com"gksachdev46@gmail.com</a>.</p>
    </div>
</body>
</html>
