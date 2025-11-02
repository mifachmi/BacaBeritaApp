# BacaBeritaApp

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin_Multiplatform-KMP-blue?logo=kotlin&logoColor=white)](https://kotlinlang.org/docs/multiplatform.html)
[![Compose Multiplatform](https://img.shields.io/badge/Compose-Multiplatform-4285F4?logo=jetpackcompose&logoColor=white)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![Android](https://img.shields.io/badge/Android-Supported-3DDC84?logo=android&logoColor=white)](https://developer.android.com/)
[![iOS](https://img.shields.io/badge/iOS-Supported-000000?logo=apple&logoColor=white)](https://developer.apple.com/)

Kotlin Multiplatform (KMP) news reader dengan **Compose Multiplatform** yang menargetkan **Android** dan **iOS**. Fokus proyek ini adalah _shared UI_ dan _shared logic_ lintas platform, pemuatan konten berita dari resource/JSON, serta eksplorasi integrasi fitur platform seperti **Text-to-Speech** (Android) dan **Share Sheet** (iOS).

## ✨ Fitur Utama

- ✅ **Kotlin Multiplatform + Compose Multiplatform**: 1 codebase untuk Android & iOS (shared UI).
- 📰 **Breaking News UI** dengan komponen Compose (card, list, action bar share/bookmark/audio).
- 📦 **Resource management** via `compose-resources` (gambar & JSON di `commonMain`).
- 🔊 **Text-to-Speech (Android)** melalui antarmuka `TextToSpeech` (expect/actual).
- 📤 **Share Text (iOS)** via `UIActivityViewController` (helper `rememberShareHandler()`).
- 🧭 **Navigation (Android)** dengan `androidx.navigation-compose`.
- 🗂️ **Arsitektur modular**: `composeApp` (shared), `iosApp` (entry point iOS).

## 📱 Demo

> **Video Demo**
>
> - GDrive: `https://drive.google.com/file/d/1P46CDl5Q2cPKNvxBy9nfR9Ux13BoSzpo/view?usp=sharing`

## 🗃️ Struktur Proyek

```text
BacaBeritaApp/
├─ composeApp/            # Shared KMP module (Compose Multiplatform UI + logic)
│  └─ src/
│     ├─ commonMain/      # Kode & resource bersama (UI, model, util, images/json)
│     ├─ androidMain/     # Implementasi Android (actual), integrasi AndroidX
│     └─ iosMain/         # Implementasi iOS (actual), integrasi UIKit/Swift
├─ iosApp/                # Entry point iOS (project Xcode, Swift/SwiftUI glue)
├─ gradle/                # Wrapper
├─ build.gradle.kts
├─ settings.gradle.kts
└─ README.md
```

## 🧰 Teknologi & Library

Berikut kumpulan dependensi dan API yang digunakan di proyek KMP + Compose:

- **Kotlin Multiplatform** & **Compose Multiplatform**
  - `org.jetbrains.compose` (UI, Material3, `compose-resources`)
  - Shared UI di `commonMain`; platform-specific di `androidMain`/`iosMain`
- **Android (khusus)**
  - `androidx.activity:activity-compose`
  - `androidx.lifecycle:lifecycle-viewmodel-compose`
  - `androidx.lifecycle:lifecycle-runtime-compose`
  - `androidx.navigation:navigation-compose`
  - **Text-to-Speech** API (wrapper interface `TextToSpeech`)
- **iOS (khusus)**
  - UIKit (`UIActivityViewController`, `UIApplication`, dsb.) untuk share sheet
  - Swift/SwiftUI sebagai entry point proyek di `iosApp`
- **Resource & Serialization**
  - `compose-resources` untuk gambar & file JSON di `commonMain`
  - `kotlinx.serialization` untuk parsing JSON (siap pakai)
- **(Opsional/Planned) Storage & Network**
  - **SQLDelight** (sudah ada _expect_ untuk `DatabaseDriverFactory`)
  - **Ktor** untuk HTTP client (bisa ditambahkan saat integrasi API)