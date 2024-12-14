# Práctica 05 - Componentes ListView y Spinner

**Instrucciones**: Desarrolle una aplicación móvil en plataforma Android, utilizando el paradigma orientado a objetos y arreglo de objetos. investigando como pasar como parámetro a otra Activity el arreglo de objetos.

En la parte de diseño debe contemplar lo siguiente:
* Agregar componentes como cajas de texto, Imagebutton, etiquetas,  botones de opción (Chip, Switch o togglebutton cualquiera de ellos) y Listas (ListView y Spinner), que cumplan con la información definida en la clase (descrita líneas abajo).
* Especificar separación entre componentes y margen del tamaño de la pantalla (vista blue print).
* Utilizar etiquetas definidas en el archivo Strings.xml

En la funcionalidad de cubrir lo siguiente:
* Trabajar con la clase **Concierto**, cada quien define los atributos (mínimo 5).
* Declarar un arreglo de objetos de la clase anterior, con tamaño de 5.
* Programar la funcionalidad de cuatro botones: *Registrar*, *Buscar*, *Limpiar* y *Eliminar* que a continuación se describe su actuar.

El *botón Registrar* debe colocar los datos del formulario de la Activity en una posición dentro del arreglo de objetos. Se debe validar que exista espacio dentro del arreglo, de lo contrario notificar al usuario de falta de espacio. Cuando concluya el registro, deben limpiarse los componentes (volver al estado inicial) y notificar al usuario del registro realizado.

El *botón Buscar* debe tomar el valor escrito en código y con ello buscar dentro del arreglo de objetos la información. Si existe debe ser mostrado en otra Activity  (TextView). En caso de no existir enviar un mensaje al usuario notificando la situación.

El *botón Limpiar* debe borrar el contenido de los componentes, dejando todo en un estado inicial.

El *botón Eliminar* considera el código como atributo para realizar la búsqueda dentro del arreglo y en caso de existir debe borrar la información. En caso de no existir enviar un mensaje al usuario notificando la situación.
