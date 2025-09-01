# Spotlight - A College Event Newspaper App

[cite_start]An Android application designed for students to discover and share upcoming events happening in nearby colleges[cite: 81].

## About The Project

The idea for Spotlight was born from the common challenge college students face in keeping track of various fests, workshops, and competitions happening across different local campuses. This project aimed to be a centralized, real-time platform to bridge this information gap, acting as a digital notice board for the student community.

[cite_start]Built as my first personal project in college [cite: 81][cite_start], it was a practical application of mobile development principles using Java for the frontend and Firebase for all backend services[cite: 81].

## Key Features

* [cite_start]**User Authentication:** Secure sign-up and login functionality to ensure that only registered users can post events[cite: 82].
* [cite_start]**Real-Time Event Feed:** A dynamic, scrollable feed of all posted events, which updates in real-time for all users as new events are added, powered by Firebase Realtime Database[cite: 82].
* **Event Creation & Media Upload:** Authenticated users can create new event listings, complete with titles, descriptions, dates, and venues. [cite_start]The app also includes functionality to upload and display promotional images for the events (media read and write)[cite: 82].
* **Event Discovery:** Users can browse and view the details of all submitted events, ensuring they don't miss out on local opportunities.

## Tech Stack

* **Frontend:** Java, Android SDK, XML for layouts
* **Backend & Database:** Google Firebase
    * [cite_start]**Firebase Authentication:** For managing user accounts (login/sign-up)[cite: 81, 82].
    * [cite_start]**Firebase Realtime Database:** For storing and syncing event data instantly across all devices[cite: 81, 82].
    * [cite_start]**Firebase Storage:** For handling image uploads and retrievals for event posters[cite: 81, 82].

## Learning & Development Context

[cite_start]This project was my first significant venture into native Android development[cite: 81]. The primary objective was to build a full-stack mobile application from end-to-end, applying theoretical concepts to a real-world problem.

Key takeaways from this project include:
* Mastering Android fundamentals like Activities, Intents, and UI design with XML.
* Integrating a real-time, NoSQL backend (Firebase) to create a dynamic and responsive user experience.
* Implementing a complete user authentication flow.
* Managing media data by handling file uploads and storage.

While the codebase reflects my skill set at the time, the project was invaluable in building a strong foundation for my subsequent professional work in mobile development.

## Potential Future Improvements

Given the chance to revisit this project, I would focus on:
* **Code Modernization:** Migrating the entire codebase from Java to Kotlin and implementing modern Android Architecture Components (like ViewModel, LiveData, and Room).
* **Advanced Features:** Adding features like event filtering (by college or category), push notifications for new events, and an RSVP or "I'm interested" functionality.
* **UI/UX Overhaul:** Redesigning the user interface to follow modern Material Design guidelines for a more intuitive experience.
