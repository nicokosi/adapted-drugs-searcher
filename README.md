Basic web app for searching adapted drugs. Kind of demo app for Vidal's excalibur-rest API "/rest/api/adapted-drugs".

# Quick run

1. [Install leiningen](http://leiningen.org/#install)
2. Run [https://github.com/softwarevidal/excalibur-rest](excalibur-rest) locally
3. Start interactive session: `lein figwheel`
4. Open your browser with security bypass for Cross-origin resource sharing (CORS):
For Chromium/Chrome, use the following command: `chromium-browser --disable-web-security  --user-data-dir http://localhost:3449`
For Firefox, type `about:config` in URL bar, search `security.fileuri.strict_origin_policy`, set value to `false` and open URL `http://localhost:3449`.