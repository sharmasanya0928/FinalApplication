**Student Name**: Sanya Sharma  
**Student ID**: s4678129  
**Course**: NIT3213 Mobile Application Development  
**Submission Date**: October 2024

## Overview
This project is a simple Android-based eCommerce application with a gardening theme. The app allows users to log in, view a dashboard of gardening products, and see product details. The app demonstrates the use of modern Android development technologies such as Retrofit, Hilt for Dependency Injection, and RecyclerView for displaying product lists.

## Key Features
- **Login Functionality**: Authenticate users using API requests.
- **Dashboard**: Displays a list of products with images, names, and prices.
- **Product Details**: Provides more information about a product when selected.
- **Networking**: Uses Retrofit to communicate with a backend API.
- **Dependency Injection**: Utilizes Hilt for dependency injection.
- **Manual Product Entries**: Displays a static list of products as an initial implementation.
  
## Prerequisites

Before building and running the application, ensure you have the following installed on your machine:
- **Android Studio Chipmunk (or later)**
- **Gradle 8.7 or higher**
- **Java Development Kit (JDK) 1.8 or later**
- **Android SDK with API 34** (Ensure the required SDK is installed)

## Build Instructions

### 1. Clone the Repository
Start by cloning this repository to your local machine:

```bash
git clone https://github.com/sharmasanya0928/FinalApplication.git

Open the Project in Android Studio
Launch Android Studio and open the cloned project.
Sync the project to download the necessary dependencies:
Go to File -> Sync Project with Gradle Files.
3. Run the Project
Build the Project
To build the project, use one of the following methods:

Option 1: In Android Studio, go to Build -> Rebuild Project.
Option 2: Use the Gradle wrapper from the terminal:
./gradlew build
Run the Application
To run the application on an emulator or connected device:

In Android Studio, select Run -> Run 'app' or press Shift + F10.
4. Testing
Unit Tests
You can run unit tests either in Android Studio or from the terminal:

Option 1: In Android Studio, right-click on a test class (e.g., LoginActivityTest) and select Run 'Test'.
Option 2: From the terminal, run:
./gradlew test
Project Features
Login Activity: Allows users to log in by providing their credentials.
API Integration: Communicates with a backend API for user authentication via Retrofit.
Dashboard Activity: After successful login, the app navigates to a dashboard displaying user information.
Dependency Injection: Hilt is used for managing dependencies such as ApiService.
Unit & UI Testing: Includes JUnit for unit testing and Espresso for UI testing.
Dependencies
Retrofit 2.9.0: For making API requests.
OkHttp Logging Interceptor 4.10.0: For logging network traffic.
Hilt 2.48: For dependency injection.
Espresso 3.4.0: For UI testing.
JUnit 4.13.2: For unit testing.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Replace `https://github.com/sharmasanya0928/FinalApplication.git` with the actual URL of your GitHub repository before submitting the project. You can also create or edit the `LICENSE` file in the repository if needed. This format is optimized for GitHub Markdown rendering.


