package user

import (
	"encoding/json"
	"fmt"
	"golang_ws_template/src/clients"
	"golang_ws_template/src/models"
	"net/http"
)

func Register(w http.ResponseWriter, r *http.Request) {
	var creds models.Credentials
	err := json.NewDecoder(r.Body).Decode(&creds)
	if err != nil {
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	if (models.Credentials{}) == clients.MongoDBUserFind(creds) {
		clients.MongoDBUserCreate(creds)
	} else {
		w.WriteHeader(http.StatusUnauthorized)
		fmt.Println("User already exists")
	}
}
