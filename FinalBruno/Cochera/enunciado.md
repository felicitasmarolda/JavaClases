Reserva de Cochera
Una empresa quiere mejorar la distribución de uso de la única cochera que tienen entre sus empleados.
Para eso nos piden hacer un programa para que decida quién debe usar la cochera en base a los pedidos de uso que hubo de ella para una fecha particular.
El sistema debe permitir recibir pedidos de reserva con uno de los motivos para una persona, en una fecha.

Los motivos pueden ser: 1) Tengo reunión con cliente 2) Tengo que dar una clase 3) Uso personal.
Sólo se puede consultar quién es asignado una vez cerrada la fecha.
Cuando se cierra para un día ya no se pueden hacer más reservas para ese dia.
Si se cierra una fecha sin postulantes, no se podra consultar esa fecha.
La asignación de la cochera se hace de la siguiente forma:
1) si hay un solo pedido, se le otorga a esa persona
2) si hay más de uno para una misma fecha, se prioriza por motivo. Tiene prioridad la reunión con el cliente, luego dar clase y por último el uso personal.
3) A una misma prioridad, tiene preferencia el pedido anterior.

Hint:  java.time.LocalDate es una clase conveniente para este ejercicio.
Se pueden obtener instancias de un día particular como LocalDate.of( <año>, <mes>, <dia> );
