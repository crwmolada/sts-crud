# Sistema de Gestión de Ventas
Este proyecto es una aplicación de escritorio para gestionar ventas y productos, desarrollada en Java con Swing y conectada a una base de datos MySQL. Proporciona funcionalidades para registrar y consultar ventas, productos y detalles de transacciones.

# Características
- **Gestión de Ventas**: Agregar, actualizar y eliminar ventas.
- **Detalles de Venta**: Visualizar detalles específicos de cada venta, como productos comprados, cantidades y clientes.
- **Cálculo Automático**: Genera automáticamente el total de la venta aplicando descuentos.
- **Consultas Avanzadas**: Usa SQL para obtener detalles de ventas y productos asociados mediante claves foráneas.
  
# Requisitos
- **Java** 11 o superior
- **MySQL** o base de datos compatible
- **STS** (Spring Tool Suite) o **IDE de Java** compatible
  
# Estructura del Proyecto
- **Modelo (`com.edu.certus.model`)**: Contiene las clases `Venta`, `Producto` y `DetalleVenta`.
- **DAO (`com.edu.certus.dao`)**: Define la capa de acceso a datos. Los métodos de cada clase DAO gestionan las operaciones CRUD en la base de datos.
- **Servicio (`com.edu.certus.service`)**: Lógica de negocio que coordina la comunicación entre los controladores y la capa DAO.
- **Controlador (`com.edu.certus.controller`)**: Define la interfaz de usuario y controla las interacciones de esta con los servicios.
  
## Instalación y Configuración

1. **Base de Datos**: Configura una base de datos en MySQL (`sysventa`) y carga las tablas necesarias (`venta`, `producto`, `detalleventa`, etc.). Consulta el archivo `schema.sql` si existe, o usa las sentencias SQL incluidas en el proyecto.
2. **Configuración de Base de Datos**: Asegúrate de que los parámetros de conexión (`ConexionDB`) estén correctos.
3. **Ejecución**: Inicia el proyecto desde el controller a usar en tu IDE.
   
## Ejemplo de Consulta SQL

Para visualizar detalles de una venta, incluyendo descuentos y el cálculo de pago final:

```sql
SELECT 
    dv.codigoventa,
    v.cliente,
    p.nombre AS nombre,
    p.precio * dv.cantidad AS pago_inicial,
    dv.descuento,
    (p.precio * dv.cantidad) - dv.descuento AS pago_final
FROM 
    detalleventa dv
JOIN 
    venta v ON dv.codigoventa = v.codigoventa
JOIN 
    producto p ON dv.codigoproducto = p.codigoproducto;
