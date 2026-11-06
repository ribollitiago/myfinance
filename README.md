# MyFinance

A first-generation Android personal finance app built in Java with Firebase — supporting user authentication and basic income/expense tracking. This project laid the groundwork for a more complete finance product.

---

## Highlights

- Firebase Authentication (email/password sign-up and login)
- Income and expense entry with categorization
- Real-time data persistence via Firebase Realtime Database
- Native Android UI built entirely in Java with XML layouts
- Activity-based navigation with Intent passing

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Platform | Android SDK |
| Backend | Firebase Authentication + Realtime Database |
| UI | XML Layouts, Activities |
| Build | Gradle |

---

## Getting Started

### Prerequisites

- Android Studio (latest stable)
- Android SDK (API 21+)
- A Firebase project with Authentication and Realtime Database enabled
- `google-services.json` placed in the `app/` directory

### Build & Run

1. Clone the repository.
2. Add your `google-services.json` to `app/`.
3. Open in Android Studio and click **Run ▶**, or:

```bash
./gradlew assembleDebug
./gradlew installDebug
```

---

## Author

**Tiago Ribolli Blasquez**  
[linkedin.com/in/tiagoribolli](https://linkedin.com/in/tiago-ribolli-blasquez-060810244) · [github.com/ribollitiago](https://github.com/ribollitiago)
