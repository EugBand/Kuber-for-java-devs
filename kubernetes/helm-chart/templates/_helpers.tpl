{{- define "app.currentDateTime" -}}
{{ now | date "2006-01-02T15-04-05" }}
{{- end -}}
{{- define "app.currentVersion" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace " " "_" -}}
{{- end -}}