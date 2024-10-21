# Práctica Obligatoria Agentes

Esta práctica se debe de realizar con agentes implementados en la plataforma **JADE**. La práctica consiste en la simulación de la agencia de viajes **El Corte Inglés**. El agente `CorteIngles` recibirá peticiones de un agente `Usuario` para hacer determinadas reservas de viaje. Se pueden desplegar varios agentes `Usuario` que se comunicarán con un mismo agente `CorteIngles`. Todas las fechas hacen referencia al mes de **mayo de 2025**.

## Agentes involucrados

### 1. Agente Usuario

El agente `Usuario` hará las siguientes preguntas al usuario por consola:

1. **¿Desea hacer un viaje?**  
   En caso de respuesta afirmativa del usuario, se solicitará por consola la siguiente información:
   - **Destino**
   - **Fecha Ida** (del 1/05/2025 al 30/05/2025)
   - **Fecha Vuelta** (del 2/05/2025 al 31/05/2025)

Una vez introducida esta información, el agente `Usuario` comunicará la información necesaria al agente `CorteIngles`, que se encargará de hacer una reserva de hotel. A partir de este punto, se continuará con el paso 1 indicado en el agente `CorteIngles`.

### 2. Agente CorteIngles

El agente `CorteIngles` llevará a cabo las siguientes acciones:

1. Cuando `CorteIngles` reciba una consulta del agente `Usuario` referente a un viaje, enviará un mensaje al agente `Alojamiento` buscando una posible reserva en función del destino y las fechas.
   - **Si hay disponibilidad** para esas fechas y destino, el agente `Alojamiento` hace la reserva en cualquiera de los hoteles disponibles y lo notifica al agente `CorteIngles`. Este notificará al agente `Usuario` que el trámite se ha realizado correctamente y el agente `Usuario` imprimirá por pantalla la información de la reserva.
   - **Si no hay disponibilidad**, el agente `CorteIngles` notificará al agente `Usuario` la imposibilidad de realizar la reserva para esa fecha. El agente `Usuario` imprimirá un mensaje indicando que para esa fecha no hay plazas disponibles en esa ciudad. (Donde pone *fecha* y *ciudad* se debe indicar el valor de las mismas).

### 3. Agente Alojamiento

Almacenará la información correspondiente a la siguiente tabla:

| Ciudad     | Nombre Hotel | Número habitaciones | Calendario Ocupación |
|------------|--------------|---------------------|----------------------|
| Vigo       | Playa Samil  | 2                   | ...                  |
| Plasencia  | Parador      | 1                   | ...                  |
| Madrid     | Plaza Colón  | 2                   | ...                  |
| Madrid     | Bernabeu     | 1                   | ...                  |
| Madrid     | Cibeles      | 3                   | ...                  |

El número de hoteles por ciudad y habitaciones se debe programar para que sea fácilmente modificable el día de la defensa. No es necesario cargar la información de ficheros externos.

## Aclaración

Se penalizará que el agente `CorteIngles` se quede bloqueado esperando la confirmación del agente `Alojamiento` sin poder atender nuevas peticiones de los usuarios. El agente debería de esperar a la llegada de mensajes de usuario o alojamiento y, en función del objeto que llegue, tratarlo de manera adecuada.

