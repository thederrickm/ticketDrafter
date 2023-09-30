package user

import (
	"encoding/json"
	"fmt"
	"golang.org/x/crypto/bcrypt"
	"golang_ws_template/src/clients"
	"golang_ws_template/src/models"
	"net/http"
)

func Signin(w http.ResponseWriter, r *http.Request) {
	var creds models.Credentials
	err := json.NewDecoder(r.Body).Decode(&creds)
	if err != nil {
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	storedCreds := clients.MongoDBUserFind(creds)

	if storedCreds.Username != "" {
		// PW check does nothing if fails; returns 200 OK but no JWT (fix to unauth)
		if err = bcrypt.CompareHashAndPassword([]byte(storedCreds.Password), []byte(creds.Password)); err == nil {
			CreateJWT(creds, w)
		}
	} else {
		fmt.Println("User does not exist or bad password")
		w.WriteHeader(http.StatusUnauthorized)
		return
	}
}
