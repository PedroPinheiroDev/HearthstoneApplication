# HearthstoneApplication

Application to list classic Hearthstone cards and their details.

## Main Libraries

**Retrofit** - HTTP requests

Retrofit is the most widespread library to handle HTTP requests, in addition to having an easy implementation.

**Jetpack Compose** - Ui toolkit

A declarative ui toolkit developed with the aim of simplifying the creation of graphical interfaces on Android.

**Koin** - Service Locator

**Coil** - Image renderer

**Mockk** - Mocking

## Architecture

- I chose to adopt an architecture between MVVM and MVI for having a high degree of decoupling in addition to allowing the use of lifecycle libraries.

## Improvements

- Create a Dimens.kt file to store and center the dimensions used across the application.
- Test all features and all layers.
- Refine the UI.
