# language: es
Característica: Creacion de plataformas
  Como usuario de backoffice quiero poder crear plataformas

Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Cuando presiono "_submit"
    Y sigo "Listar Cuentas"
    Y debe aparecer el contenido dinámico "GoIntegro Argentina" en ".string-cell"
    Y sigo "Child"
    Y sigo "Listar Plataformas"
    Y debe aparecer el contenido dinámico "Plataforma Test" en ".string-cell"
    Y sigo "Nueva Plataforma"
    Entonces espero a que aparezca el contenido dinámico "Crear plataforma " en ".backoffice-header"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una nueva plataforma con los campos obligatorios
    Dado relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "countries-1"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Plataforma de testing" en ".company-site"
    Entonces debo ver "Identificador único"
    Y debo ver "email"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una nueva plataforma con un nombre que ya esta siendo utilizado por otra plataforma para esta cuenta.
    Dado relleno "name" con "Plataforma Test"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva2.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y tildo el checkbox "countries-0"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Ya existe una plataforma con este nombre para la cuenta GoIntegro Argentina - Test P Child" en ".alert-error"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una nueva plataforma sin completar los campos obligatorios.
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name"
    Y debo ver "Este campo no puede estar vacío" en el elemento ".form-webSite"
    Y debo ver "La plataforma debe tener al menos un país asociado" en el elemento ".form-countries"
    Y debo ver "Este campo no puede estar vacío" en el elemento ".form-logoUrl"
    Y debo ver "Este campo no puede estar vacío" en el elemento ".form-logoUrlFooter"
    Y debo ver "Este campo no puede estar vacío" en el elemento ".form-signinBannerUrl"

@javascript @createAccountAndUserAndPlatform
Escenario: Cancelar la creación de una nueva plataforma.
    Dado relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva4.ci.gointegro.net"
    Cuando adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Cuando presiono "Cancelar"
    Entonces la URL debe seguir el patrón "/backoffice/account/\d+/platform/list"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una plataforma y volver al formulario para crear otra plataforma.
    Dado relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva5.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Cuando presiono "Guardar y nuevo"
    Entonces la URL debe seguir el patrón "/backoffice/account/\d+/platform/create"

@javascript @createRegionalAccountWithPlatform
Escenario: Crear una plataforma para una cuenta regional verificando que no haya campos de registro/login ni customizacion.
    Dado relleno "name" con "Platform no regional"
    Y relleno "storage" con "400"
    Y relleno "webSite" con "http://plataformaNueva6.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y selecciono "0-100" de "usersRange"
    Y tildo el checkbox "countries-0"
    Y no debo ver "Logo principal"
    Y no debo ver "Logo secundario"
    Y no debo ver "Banner para inicio de sesión"
    Y no debo ver "Usa tarjeta"
    Y no debo ver "Usa fecha de nacimiento"
    Y no debo ver "Usa género"
    Y no debo ver "Configuración de inicio de sesión y registro"
    Y no debo ver "Tipo de Login"
    Y no debo ver "Campo usuario"
    Y no debo ver "Recuperar contraseña"
    Y no debo ver "Requiere verificación"
    Y no debo ver "Fondo plataforma"
    Y no debo ver "Fondo header y footer"
    Y no debo ver "Texto header y footer"
    Y no debo ver "Texto botones"
    Y no debo ver "Fondo botones"
    Y no debo ver "Borde header y footer"
    Y no debo ver "Íconos home"
    Y no debo ver "Texto del login"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces espero a que aparezca el contenido dinámico "Platform no regional" en ".company-site"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una plataforma completando los campos de alamacenamiento con errores
    Dado relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "aaaaa"
    Y relleno "imageSize" con "123123asdasd"
    Y relleno "webSite" con "http://plataformaNueva5.ci.gointegro.net"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "El valor ingresado debe ser un número entero" en ".form-storage"
    Y debo ver "El valor ingresado debe ser un número entero" en el elemento ".form-imageSize"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una plataforma con mostrar cupones activado.
    Dado relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva.ci.gointegro.net"
    Y relleno "mobileActivationCode" con "plataformaNueva"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "usesCoupon"
    Y tildo el checkbox "benefitsEnabled"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Plataforma de testing" en ".company-site"
    Entonces debo ver "Identificador único"
    Y debo ver "email"
    Y debo ver "Si" en el elemento "#usesCoupon"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una plataforma con mostrar cupones desactivado.
    Dado relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "0-100" de "usersRange"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "benefitsEnabled"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Plataforma de testing" en ".company-site"
    Entonces debo ver "Identificador único"
    Y debo ver "email"
    Y debo ver "No" en el elemento "#usesCoupon"

@javascript @createAccountAndUserAndPlatform
Escenario: Habilitar el catálogo de premios.
    Dado relleno "name" con "Plataforma con catálogo de premios"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformapremios.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y relleno "mobileActivationCode" con "plataformapremios"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "countries-1"
    Cuando presiono "Guardar"
    Entonces espero a que cambie la URL
    Y espero a que aparezca el contenido dinámico "Plataforma con catálogo de premios" en ".breadcrumb"