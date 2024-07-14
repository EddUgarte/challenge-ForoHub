<h1> FORO HUB CHALLENGE </h1>

<h3> DESCRIPCIÓN </h3>
Aplicación que gestiona el Backend de un Foro; los usuarios podrán CREAR, LISTAR, ACTUALIZAR o ELIMINAR los Tópicos que correspondan a su cuenta siempre y cuando su usuario y contraseña estén registrados en la plataforma y tengan los permisos para hacerlo ya que la aplicación cuenta con una capa de Seguridad que permite y/o bloquea ciertas acciones dependiendo el rol que cada usuario posee.

<h3> FUNCIONAMIENTO </h3>
Para probar la API, se cuenta con los endpoint necesarios para el CRUD básico y uno más para el LOGIN.

Si intentamos realizar una acción, como un listado de todos los Topicos existentes, sin estar Autenticados correctamente, la respuesta será un cógido HTTP 403 Forbidden (No permitido)
![image](https://github.com/user-attachments/assets/57a2107a-fa1e-436c-a8ff-245074b461e7)

Para tener acceso a los diferentes endpoints, primero debemos ir al endpoint Autenticación y mandar en el body de la solicitud un usuario y contraseña válidos (que se encuentren registrados en la Base de Datos), si es así, se generará un JWT (JSON Web Token) que debemos usar como método de autenticación cada que realicemos una solicitud Get, Post, Put o Delete a la API.
![image](https://github.com/user-attachments/assets/64c3b761-308f-4f0a-8deb-904629df84a7)

En la página jwt.io podemos validar que ese JWT es correcto y tiene asignado un periodo de vigencia:
![image](https://github.com/user-attachments/assets/981d653a-244e-4cbe-995c-8e9bb2be0f35)

Para crear un nuevo Tópico, debemos enviar ese JWT en la solicitud:
![image](https://github.com/user-attachments/assets/ae6c391b-a51e-4ad5-8bfc-d7e3d969be38)

Así mismo, en el Body de la solicitud se mandan los parámetros necesarios para crear el Tópico y al enviar, se responde con un código HTTP 201 Created, así como los datos del Tópico que acabamos de crear
![image](https://github.com/user-attachments/assets/c90e251d-b7e7-46f0-b161-39df55cb2355)

Si queremos actualizar ese mismo Tópico, debemos enviar el JWT en la solicitud (siempre y cuando aún se encuentre válido ya que tiene una vigencia de 3horas unicamente)
![image](https://github.com/user-attachments/assets/de4b2a58-f2ca-4f35-a4d9-9d84631ca5ea)

Así mismo, en el body de la solicitud se mandan los parametros necesarios para la Actualización del Tópico y al enviar, se responde con un código HTTP 200 OK, así como los datos del Tópico actualizado y cambiando su estatus de "nuevo" a "updated".
![image](https://github.com/user-attachments/assets/bfe855f0-3341-42f2-83f9-1f27e7efc550)

Si queremos listar todos los Tópicos, simplemente debemos enviar un JWT válido en la solicitud. Se responderá con un código HTTP 200 Ok, así como toda la lista de tópicos existentes en formato JSON.
![image](https://github.com/user-attachments/assets/5456fde0-e80b-494a-89c4-9106d3eb7242)

![image](https://github.com/user-attachments/assets/41894934-0cf9-4829-9097-a06e4f9eb6e3)

Así mismo, para eliminar un Tópico, se debe mandar un JWT válido en la solicitud y, en la url el parámetro id del tópico a eliminar. Se responderá con un código HTTP 204 No Content.
![image](https://github.com/user-attachments/assets/a8d60db9-26ad-4988-b8ab-e60f0284883f)

Para comprobar que el mensaje ha sido eliminado correctamente, se listan todos los tópicos con el método Get y se observa que el Tópico con id=3 ya no existe.
![image](https://github.com/user-attachments/assets/91db9add-c10a-478e-ad7c-c8ef27a2ba18)

Finalmente, podemos buscar un Tópico específico mandando como parámetro de la url su id (Así como un JWT válido). Se responderá con un código HTTP 200 Ok acompañado del contenido de dicho tópico.
![image](https://github.com/user-attachments/assets/ae82ca54-a790-4041-9129-e1645378f25d)

<h3> TECNOLOGÍAS UTILIZADAS </h3>
*Java 21
*Spring Boot
*Spring Security

<h3> DESARROLLADOR </h3>
*Edgar Sandoval Ugarte
