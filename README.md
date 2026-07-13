# Programacion3---JavaFXTarea2---AndyGomez

## Andy Delcio Gomez Moya

## Matricula: 1000-6215

## Materia: Programacion 3

# Tarea JavaFX: Sistema de Registro de Paquetes y Destinos

## Objetivo de aprendizaje

Desarrollar una aplicación de escritorio en JavaFX utilizando FXML y una estructura MVC simple, integrando múltiples ventanas, `MenuBar`, formularios, `ComboBox`, `TableView` o `ListView`, archivos de texto, hilos y `Platform.runLater()`.

La finalidad de esta práctica es que el estudiante pueda aplicar programación orientada a objetos, manejo de eventos, lectura y escritura de archivos, y ejecución de procesos en segundo plano sin congelar la interfaz gráfica.

---

## Descripción general

Una empresa de mensajería necesita una aplicación para registrar paquetes y destinos. El sistema debe permitir guardar la información en archivos de texto y luego cargarla nuevamente para consultarla desde la interfaz gráfica.

La aplicación debe tener dos registros principales:

1. Registro de destinos.
2. Registro de paquetes.

Ambos registros deben almacenarse en archivos independientes.

---

## Archivos requeridos

La aplicación debe trabajar con al menos dos archivos de texto:

```text
destinos.txt
paquetes.txt
```

El archivo `destinos.txt` almacenará los destinos registrados.

Ejemplo:

```text
Santo Domingo
Santiago
La Vega
Puerto Plata
```

El archivo `paquetes.txt` almacenará los paquetes registrados.

Ejemplo:

```text
PK001;Juan Perez;5.5;Santo Domingo
PK002;Maria Lopez;2.3;Santiago
PK003;Pedro Santos;8.0;Puerto Plata
```

---

## Modelo de datos

### Clase `Destino`

Debe representar un destino disponible para los paquetes.

Atributo sugerido:

```text
nombre
```

### Clase `Paquete`

Debe representar un paquete registrado en el sistema.

Atributos sugeridos:

```text
codigo
destinatario
peso
destino
```

---

## Requerimientos funcionales

### 1. Ventana principal

La aplicación debe tener una ventana principal con un `MenuBar`.

El menú debe contener opciones similares a estas:

```text
Archivo
    Registro de paquetes
    Registro de destinos
    Consulta de paquetes
    Consulta de destinos
    Salir

Procesos
    Demostrar uso de Thread y Platform.runLater
```

---

### 2. Registro de destinos

Debe existir una vista FXML para registrar destinos.

La vista debe contener:

- Un `TextField` para escribir el nombre del destino.
- Un botón `Guardar en archivo`.
- Un botón `Cargar desde archivo`.
- Un `ListView` o `TableView` para mostrar los destinos cargados.
- Un `Label` para mostrar mensajes al usuario.

El botón `Guardar en archivo` debe guardar el destino en `destinos.txt`.

El botón `Cargar desde archivo` debe leer los destinos almacenados y mostrarlos en pantalla.

---

### 3. Registro de paquetes

Debe existir una vista FXML para registrar paquetes.

La vista debe contener:

- Un `TextField` para el código del paquete.
- Un `TextField` para el nombre del destinatario.
- Un `TextField` para el peso del paquete.
- Un `ComboBox` para seleccionar el destino.
- Un botón `Guardar en archivo`.
- Un botón `Cargar destinos`.
- Un `Label` para mostrar mensajes.
- Un `ProgressBar` para mostrar el avance del guardado.

El `ComboBox` debe cargarse con la información almacenada en `destinos.txt`.

El botón `Guardar en archivo` debe guardar el paquete en `paquetes.txt`.

El botón `Cargar destinos` debe leer el archivo `destinos.txt` y cargar los destinos en el `ComboBox`.

---

### 4. Consulta de paquetes

Debe existir una vista FXML para consultar los paquetes almacenados.

Esta vista debe contener:

- Un `TableView` o `ListView`.
- Un botón `Cargar desde archivo`.
- Un `Label` para mostrar mensajes.

Si usan `TableView`, las columnas sugeridas son:

| Código | Destinatario | Peso | Destino |
|---|---|---|---|

La información debe cargarse desde el archivo `paquetes.txt`.

---

### 5. Consulta de destinos

Debe existir una vista FXML para consultar los destinos almacenados.

Esta vista debe contener:

- Un `ListView` o `TableView`.
- Un botón `Cargar desde archivo`.
- Un `Label` para mostrar mensajes.

La información debe cargarse desde el archivo `destinos.txt`.

---

## Uso obligatorio de archivos

La aplicación debe utilizar clases de manejo de archivos vistas en clase, por ejemplo:

```java
FileWriter
FileReader
BufferedReader
IOException
```
---

## Uso obligatorio de hilos y `Platform.runLater()`

La aplicación debe utilizar un `Thread` para simular un proceso de guardado o carga.

Durante ese proceso, la interfaz debe mostrar el avance utilizando:

- `ProgressBar`
- `Label`

La actualización de la interfaz gráfica desde el hilo debe realizarse usando `Platform.runLater()`.


## Estructura sugerida del proyecto

```text
src/
 ├─ Main.java
 │
 ├─ model/
 │   ├─ Paquete.java
 │   └─ Destino.java
 │
 ├─ controller/
 │   ├─ RegistroPaqueteController.java
 │   ├─ RegistroDestinoController.java
 │   ├─ ConsultaPaqueteController.java
 │   └─ ConsultaDestinoController.java
 │
 ├─ utils/
 │   ├─ Navegacion.java
 │   └─ ArchivoUtil.java
 │
 └─ view/
     ├─ registro_paquete.fxml
     ├─ registro_destino.fxml
     ├─ consulta_paquete.fxml
     └─ consulta_destino.fxml
```

---

## Requerimientos técnicos

La aplicación debe cumplir con lo siguiente:

- Utilizar JavaFX.
- Utilizar FXML.
- Utilizar estructura MVC simple.
- Utilizar al menos dos ventanas diferentes.
- Utilizar `MenuBar`.
- Utilizar `ComboBox` para seleccionar destinos al registrar paquetes.
- Utilizar `TableView` o `ListView` para consultar información.
- Guardar destinos en archivo.
- Guardar paquetes en archivo.
- Cargar destinos desde archivo.
- Cargar paquetes desde archivo.
- Utilizar `Thread`.
- Utilizar `Platform.runLater()`.
- Manejar errores con `try-catch`.

---

## Restricciones

No se permite guardar la información solamente en arreglos o listas en memoria.

No se debe guardar la misma información dos veces por un solo clic.

No se debe actualizar un `Label`, `ProgressBar`, `TableView`, `ListView` o `ComboBox` directamente desde un hilo secundario sin usar `Platform.runLater()`.
