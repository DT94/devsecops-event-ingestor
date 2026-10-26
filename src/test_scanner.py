import requests
import json

# Endpoint del controlador Spring Boot
url = "http://localhost:8080/api/v1/ingest/scan"

# Datos simulados que enviaría el escáner de red
payload = {
    "objetivo": "192.168.1.105",
    "resultadosJson": json.dumps({
        "puertos_abiertos": [22, 80, 443],
        "servicios": ["ssh", "http", "https"],
        "nivel_riesgo": "Medio",
        "vulnerabilidades": ["Ninguna detectada en escaneo superficial"]
    })
}

headers = {"Content-Type": "application/json"}

try:
    print(f"[*] Enviando reporte de escaneo a {url}...")
    response = requests.post(url, data=json.dumps(payload), headers=headers)
    print(f"[+] Status Code: {response.status_code}")
    print(f"[+] Respuesta del backend: {response.text}")
except requests.exceptions.ConnectionError:
    print("[-] Error: No se pudo conectar. Verifica que Spring Boot siga corriendo en el puerto 8080.")