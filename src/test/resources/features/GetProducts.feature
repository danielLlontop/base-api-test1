Feature: Obtener productos

  Como: un usuario de la API de productos
  Quiero: obtener los productos disponibles
  Para: poder comprar productos

  @GetProducts
  Scenario: Obtener todos los productos exitosamente
    Given el actor establece el endpoint para obtener los productos
    When el envia una solicitud GET
    Then el codigo de respuesta deberia ser 200