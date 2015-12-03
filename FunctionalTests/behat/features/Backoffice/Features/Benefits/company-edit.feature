#language: es
Característica: Como usuario administrador del backoffice quiero editar un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y hago click y sigo ".action-icon:first"
        Y espero a que aparezca el contenido dinámico "Editar comercio" en ".breadcrumb"
        Y espero a que aparezca el contenedor dinámico ".company-form .form-horizontal"
        
    @javascript @loadBenefitsData
    Escenario: Crear un nuevo comercio
        Dado hago click en "#active"
        Y relleno "name" con "Topper"
        Y relleno "companyName" con "Topper S.A."
        Y relleno "taxId" con "234561232"
        Y relleno "phone" con "01123235689"
        Y relleno "fax" con "0112356489"
        Y relleno "description" con "Esta es la descripción de prueba para cargar un comercio"
        Y adjunto el archivo "homerosapiens.jpg" a "file-image1"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"
        Y relleno "webSite" con "http://www.topper.com.ar"
        Y agrego tag "zapatillas" en el elemento "#tag-input"
        Y agrego tag "botines" en el elemento "#tag-input"
        Y relleno "zipCode" con "1212"
        Y presiono "Cambiar ubicación"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alvarez Thomas 198 ciudad autónoma de buenos aires" y presiono enter
        Y hago click en ".search-btn"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico ".company-basic-information"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de Comercios > Topper"
        Y la URL debe seguir el patrón "/backoffice/benefits/company/\d+/view"

    @javascript @loadBenefitsData
    Escenario: Crear un comercio sin los datos obligatorios
        Dado relleno "name" con " "
        Y relleno "companyName" con " "
        Y relleno "taxId" con " "
        Y relleno "phone" con " "
        Y relleno "fax" con "0112356489"
        Y relleno "description" con " "
        Y adjunto el archivo "homerosapiens.jpg" a "file-image1"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"
        Y relleno "webSite" con "http://www.topper.com.ar"
        Y presiono "Cambiar ubicación"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alvarez Thomas 198 ciudad autónoma de buenos aires" y presiono enter
        Y hago click en ".search-btn"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-companyName .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-taxId .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-phone .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-description .help-block"

    @javascript @loadBenefitsData
    Escenario: Crear un comercio sin respetar el máximo de caracteres en los campos
        Dado hago click en "#active"
        Y relleno "name" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"
        Y relleno "companyName" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"
        Y relleno "taxId" con "234561232"
        Y relleno "phone" con "01123235689"
        Y relleno "fax" con "0112356489"
        Y relleno "description" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"
        Y adjunto el archivo "homerosapiens.jpg" a "file-image1"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"
        Y relleno "webSite" con "http://wwww.topper.com.ar"
        Y presiono "Cambiar ubicación"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alvarez Thomas 198 ciudad autónoma de buenos aires" y presiono enter
        Y hago click en ".search-btn"
        Y relleno "zipCode" con "1212"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces debo ver "El nombre del comercio no puede superar los 80 caracteres"
        Y debo ver "La razón social del comercio no puede superar los 80 caracteres"
        Y debo ver "La descripción del comercio no puede superar los 500 caracteres"