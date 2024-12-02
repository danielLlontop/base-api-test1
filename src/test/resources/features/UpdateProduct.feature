
Feature: Actualizar producto

  Como: un usuario de la API de productos
  Quiero: modificar los detalles de un producto
  Para: actualizar los datos de un producto

  @UpdateProduct
  Scenario Outline: Actualizar un producto exitosamente
    Given el actor establece el endpoint para actualizar el producto
    When el envia una solicitud PUT con el producto "<title>" "<price>" "<description>" "<image>" "<category>"
    Then el codigo de respuesta deberia ser 200
    Examples:
      | title       | price | description | image | category |
      | Coca Cola    | 10    | good product | https://i.pravatar.cc | drinks |







