
DOCUMENTO DE PROGRAMACIÓN PRIMERA ENTREGA DEL PROYECTO
PENSAMIENTO COMPUTACIONAL Y JUSTIFICACIÓN DE PATRONES 

Melany Yiseth Gomez Bacca, Elizabeth Cuellar Vélez, Isabella Ochoa Escobar

--------------------------Pensamiento computacional----------------------------
1.1 ¿Qué solicita finalmente?
Una plataforma integral para la gestión logística de eventos y venta de entradas que permita a usuarios finales comprar tickets y a administradores gestionar el catálogo, aforo y métricas.
1.2 ¿Qué información es relevante?
Datos del usuario (id, pago), detalles del evento (fecha, ciudad, estado), estructura del recinto (zonas, asientos numerados), transacciones (compras, entradas generadas, servicios adicionales) e incidencias operativas. 
1.3 ¿Cómo se agrupa la información relevante? 
Se agrupa en entidades, las cuales son:
Usuario, Evento, Recinto, Zona, Asiento, Compra, Entrada e Incidencia. 
1.4 ¿Qué funcionalidades se solicitan?
Login, filtrado de eventos, selección de asientos, gestión de pagos, adicción de servicios extra (VIP, seguros), reembolsos y generación de reportes operativos. 
1.5 ¿Cómo se distribuyen las funcionalidades?
Modelo usuario: Búsqueda, compra y gestión de perfíl. 
Modelo administrador: Gestión de inventario(eventos/asientos), control de incidencias y visualización de métricas con JavaFX. 
1.6 ¿Qué debo hacer para probar las funcionalidades?
Simular procesos de compra completos y verificar que el cambio de estado de un asiento (de Disponible a  Vendido) se refleje correctamente en el mapa.
1.7 ¿Qué puedo reutilizar?
Uso de interfaces para comportamientos comunes como el procesamiento de pagos o la generación de reportes.
Aplicación de clases abstractas para familias de productos o servicios.
1.8 ¿Cómo pruebo/escribo la solución en Java?  
Mediante una arquitectura por capas (Controladores, Servicios, Repositorios) aplicando SOLID, usando JavaFX para la vista y Git para el control de versiones. 

----------------------------Justificación de patrones-----------------------------
2.1 ------Patrones creacionales (RF-049)------
2.1.1 Singleton 
Se usa en SesiónUsuario o ConfigSistema
RF-001
¿Por qué este?: Porque garantiza un único punto de acceso global a los datos del usuario logueado.
¿Por qué no otro?: Podríamos usar variables globales, pero eso rompe el encapsulamiento. A diferencia de una clase estática simple, el Singleton permite inicialización diferida (lazy initialization), cargando los datos solo cuando el usuario realmente hace login.
2.1.2 Factory Method
Generación de diferentes tipos de ServicioAdicional (Seguro, Merchandising, Parqueadero).
RF-009
¿Por qué este?: Centraliza la creación de objetos que comparten una interfaz pero tienen lógicas distintas.
¿Por qué no otro?: Podríamos usar un switch gigante dentro de la clase Compra, pero eso violaría el principio de Abierto/Cerrado. Con Factory, si mañana se quiere agregar "Parqueadero", solo se crea la clase nueva sin tocar el código de compra existente.
2.1.3 Builder
Construcción de la entidad Evento o Compra.
RF-023
¿Por qué este?: Los eventos tienen muchos atributos (nombre, ciudad, políticas, recinto); el Builder permite crearlos de forma clara y paso a paso. 
¿Por qué no otro?: Se podría usar un constructor normal pero tendría muchos parámetros y esto crearía demasiada confusión, por otro lado, no hay otro patrón que cumpla tan bien con esta función como el Builder.
2.2 ------Patrones estructurales (RF-050)------
2.2.1 Decorator 
Cálculo del precio final de la Entrada o Compra.
RF-009
¿Por qué este?: Permite añadir costos extras (como el seguro o acceso VIP) de forma dinámica y acumulativa.	
¿Por qué no otro?: La alternativa sería la Herencia (crear una clase EntradaConSeguro, otra EntradaVip, otra EntradaVipConSeguro). Esto generaría una explosión de clases inmanejable. El Decorator "envuelve" el objeto en tiempo de ejecución de forma mucho más limpia.
2.2.2 Adapter
Exportación de reportes a diferentes formatos (PDF con PDFBox o CSV con Apache POI).
RF-046
¿Por qué este?: Sirve para que el sistema pueda trabajar con librerías externas (como una para crear PDFs y otra para Excel) sin que el código dependa directamente de ellas.  
¿Por qué no otro?: Se podría programar directamente con la librería, pero si luego se decide cambiar de "PDFBox" a otra herramienta, se tendría que cambiar todo el código. El Adapter crea una "capa intermedia" (interfaz) que protege a la lógica de cambios externos. 
2.2.3 Composite
Gestión de la estructura del Recinto.
RF-014 
¿Por qué este?: Permite tratar a una zona pequeña y al recinto completo como si fueran el mismo tipo de objeto.
¿Por qué no otro?: Sin Composite, se tendría que hacer bucles diferentes para contar asientos en una fila, en una zona o en todo el estadio. Con este patrón, se llama a .getCapacidad() y el objeto se encarga de sumar a sus hijos automáticamente..
2.3 ------Patrones comportamentales (RF-051)------
2.3.1 Strategy 
Diferentes algoritmos de MetodoPago (Tarjeta, Transferencia, etc.) o filtros de búsqueda.
RF-021 y RF-003 
¿Por qué este?: Intercambia algoritmos de pago (Tarjeta, Efectivo, Transferencia) sin cambiar la clase que los usa.
¿Por qué no otro?: El patrón State se confunde a veces con este, pero State depende del "estado interno". Aquí el usuario elige el "cómo" quiere pagar. Usar Strategy evita llenar el código de if-else que son difíciles de testear.
2.3.2 Observer 
Actualización automática de la interfaz (JavaFX) ante cambios en eventos o asientos. 
RF-018 y RF-032 
¿Por qué este?: Permite que la interfaz gráfica reaccione de inmediato a los cambios. 
¿Por qué no otro?: Podríamos usar State pero este solo cambia la lógica interna de un objeto y para el proyecto es más importante que el mapa de asientos cambie de color visualmente cuando alguien compra, algo que el patrón State no resuelve por sí solo. Además, el Observer reduce el acoplamiento entre la lógica de negocio y la interfaz de JavaFX. 
2.3.3. State
Gestión de los estados de una Compra o un Asiento. 
RF-008 y RF-032.
¿Por qué este?: La lógica del objeto cambia según su estado actual (Disponible, Vendido, Reservado). 
¿Por qué no otro?: Elegimos State en lugar de usar múltiples variables booleanas o condicionales if-else complejos dentro de la clase Asiento. Esto permite que cada estado sea una clase independiente que controla sus propias reglas (por ejemplo, que un asiento "Vendido" bloquee automáticamente el método comprar()), haciendo el código más limpio y fácil de expandir.
2.3.4 Command
Ejecución de acciones sobre compras y gestión de inventario de asientos. 
RF-006 y RF-016
¿Por qué este?: Convierte acciones en objetos, lo que permite guardarlas en un Stack para la función de "Deshacer".
¿Por qué no otro?: Podríamos guardar copias de todo el objeto Compra (patrón Memento), pero eso consumiría demasiada memoria. El Command es más eficiente porque solo guarda la instrucción de "cómo revertir" el último paso.
