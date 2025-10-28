# ScreenOffButton (App name: off)

Proyecto Android mínimo para una app que bloquea/apaga la pantalla usando DevicePolicyManager.lockNow().

**Requisitos para compilar**
- Java 17 (JDK 17)
- Gradle (o Gradle Wrapper)
- Android SDK with platform 34 (compileSdk 34)

**Compilar**
1. Desde una máquina con `gradle` disponible:
   ```bash
   cd ScreenOffButton
   gradle assembleDebug
   ```
   El APK quedará en:
   `app/build/outputs/apk/debug/app-debug.apk`

2. Instalar con ADB:
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

**Probar**
- Al abrir la app, pulsa "Apagar pantalla".
- Si la app no es administrador de dispositivo, te pedirá activarlo.
- Activa el administrador y vuelve a pulsar el botón para bloquear la pantalla.

**Nota**
- No incluyo un APK firmado en este paquete por seguridad. Puedes generar uno localmente.
