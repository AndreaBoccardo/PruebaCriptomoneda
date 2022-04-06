Descripción
Bitcoin es una criptomoneda, un sistema de pago y mercancía que está siendo ocupada
cada vez más como una alternativa al dinero producido por los gobiernos y administrado por
los bancos. Desde su año de creación (2008) ha ido creciendo su uso, además de su valor.
Así como bitcoin, aparecen día a día nuevas criptomonedas con distintas utilidades y
características. Muchas de ellas se han incluido en las plataformas de compraventa,
pudiendo transar tal cual otro activo.
Para seguir las tendencias del mercado en el precio de las criptomonedas, se solicita crear
un Mínimo Producto Viable (MVP) para que los interesados visualicen el listado de
criptomonedas y que, al hacer un clic sobre uno de los elementos, se obtenga información
detallada, como el precio, el porcentaje de cambio del precio en las últimas 24 horas, la
capitalización del mercado o el ranking, que está directamente asociado a la capitalización
de mercado.

Alcance del proyecto
Se ha determinado construir un Producto Mínimo Viable (MVP) con 2 pantallas: una para el
listado, y otra para el detalle.
La información a desplegar proviene de una API que debe ser consumida siguiendo los
estándares de la industria, ocupando patrones de arquitectura y diseño correctamente para
construir una app escalable.

Requerimientos técnicos: arquitectura y dependencias
Aunque el alcance de la app es inicial, la arquitectura que se utilice debe permitir expandir y
modificar el proyecto, por lo que se debe construir un código legible, ordenado, indentado y
que respete los siguientes requerimientos técnicos:
● Construir la arquitectura de la app con el Modelo-Vista-VistaModel (MVVM).
● Es altamente recomendado utilizar el patrón de diseño Repository para manejar las
fuentes de datos.
● Utilizar una base de datos como la única fuente de datos, por lo que la información
leída desde la API debe ser guardada en la DB para luego presentarla en la pantalla.
● Utilizar Retrofit para la comunicación con la API. Agregar la dependencia de Retrofit
y de converter para Json, además del permiso de internet correspondiente. La
documentación de la API es docs.coincap.io.
○ Los endpoints son:
■ GET /assets
■ GET /assets/{id}
● Utilizar Kotlin para desarrollar la app.
● En el futuro se pretende agregar el manejo de cuenta de usuario, por lo que se debe
incluir en la interfaz el nombre del usuario, que debe ser guardado por la aplicación
para mostrarlo cada vez que se abra. Por el momento, ocupar SharedPreferences (o
DataStore) para guardar el nombre del usuario.

Requerimientos
1. Utilizar correctamente el lenguaje Kotlin con variables mutables (var) e inmutables
(val), definiciones de clases y sentencias propias del lenguaje. ViewBinding debe ser
utilizado para enlazar las vistas. 
2. Utilizar retrofit para consumo de API REST y acceso a recursos remotos, creando los
tres (03) componentes necesarios y agregando las dependencias. 
3. Utilizar persistencia y base de datos con ROOM, creando los tres (03) componentes
necesarios para almacenar la información sobre las cryptomonedas. Utilizar
SharedPreferences (o DataStore) para almacenar el nombre de usuario. 
4. Utilizar la arquitectura Model-View-ViewModel (MVVM), para crear el viewModel
comunicando la vista con el modelo. Además, utilizar LiveData para exponer la
información hacia las capas superiores del ViewModel. 
5. Ejecutar Corutinas para utilizar funciones suspendidas, tanto para el consumo de API
como para algunas operaciones con la base de datos. 
6. Crear el certificado y la aplicación firmada para producción. 
Los endpoints de la API no retornan la URL de la imagen por cada asset, pero la página
https://coincap.io/ los utiliza como recursos estáticos, por lo que es posible construir la URL
para la imagen de cada asset, que utiliza
https://static.coincap.io/assets/icons/{symbol}@2x.png siendo {symbol} el símbolo del
asset indicado en la respuesta.

Mejoras implementadas (opcionales)
● Utilizar test unitarios.
● Cambiar el ícono de la aplicación
● Agregar filtros en el listado para buscar criptomonedas.
