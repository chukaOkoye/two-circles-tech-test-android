# SuperScoreBoard

For all your up to the minute scores from around the globe.

1. ## How to set up and run the project

   - Open the project in Android Studio Narwhal 2025.1.2.
   - Go to **File → Open**, then use the file explorer to select the project root folder.
   - If prompted with a security message, confirm that you trust the project.
   - Gradle will sync automatically once the project opens.
   - After syncing completes, you should be able to build and run the app on your Android device or emulator.

2. ## Complete the task

   - Use the data already being fetched by the app to bring the provided [Figma designs](https://www.figma.com/design/hY3cElxFKc1mkl9oZ8GAi4/Test-Design?node-id=1-61823&t=IbXirDv081k0WauS-1) to life.
   - Aim to match the look and feel of the designs as closely as possible.
   - Show us your best practices when it comes to modelling data and presenting it on screen.
   - Write code that is testable, and add tests to demonstrate it.
   - You’re welcome to adjust or refactor any of the starter code if it helps your approach.
   - Make sure data fetching includes proper loading and error states.
   - If something about the design or data isn’t clear, make sensible assumptions—we’ll cover them in the review.
   - You can bring in frameworks if they add value, but be ready to explain your reasoning. The focus is on solid engineering, not on piling in tools for the sake of it.
   - Feel free to use the latest features from the OS, toolset, or language. There are no restrictions on minimum support.

3. ## Document and deliver

   - At the bottom of this README, include a short section with your notes.
   - Outline your approach, highlight any trade-offs you made, and call out assumptions around the data or designs.
   - This helps us understand your thinking and makes the review process smoother.
   - When you’re finished, share the completed project with us. You can either:
      - Push it to a public or private GitHub repository and share access, or
      - Send it as a zipped project folder.

---

## Candidate Notes

(Add your notes here: approach, assumptions, trade-offs, anything you’d like us to know.)

## How to run
- Have all dependencies synced in the `libs.versions.toml` and `build.gradle.kts` file.
- Click RUN
- For tests: navigate to test folder, right-click files and click "Run `test filename`"

## Tech used
- Kotlin/Jetpack Compose
- MVVM
- Coroutines
- Mockk
- JUnit

## My Approach
- I took time to understand the data being pulled from the api to determine what and how to display the various items, like the kick-off time due to the status and the scores, and how the design can be implemented based on those values before undertaking the app.
- Added to the starter project but made additional changes to the repository layer to include try/catch for api calls, allowed for more testing of the Results outcome and also made additional changes to the viewmodel to handle different UI states.
- To get the layout as close as possible to the design, I used the Digital Colour Meter program to get accurate colour values from the Figma page (native colours and fonts were not displayed).
- **Model** - Contains data models and handles data operations through a Repository abstraction, kept the same due to the correct data models being in place already.
- **ViewModel** - FixtureViewModel manages UI state, business logic, and interacts with the repository. It exposes the state as a StateFlow for Compose to observe, while also ordering the main view by competition as requested in the design.
- **View (UI)** - Composable like FixturesScreen render UI based on the current uiState, and depending on the status of the game, would display the layout suited for it, like FixtureRowScoresScreen for current games undergoing. 
- I added additional tests to the repository using JUnit and Mockk to confirm that the code is working correctly, and if I had more time would have implemented tests for the ViewModel as well.

## Future implementations
- Potential database implementation to cache and store the responses to still work whilst offline.
- Rework the fixture ui module to allow for unit tests to run like the ViewModel. I didn't have enough time to organise and implement, but the repository was tested.

## Screenshot
<img width="463" height="760" alt="Screenshot 2025-08-28 at 21 23 25" src="https://github.com/user-attachments/assets/1a2b94aa-bbfe-445c-821a-e18dd45fdb97" />

