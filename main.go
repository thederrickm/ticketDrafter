package main

import (
	"github.com/go-chi/chi/v5"
	"golang_ws_template/src/config"
	"golang_ws_template/src/user"
	"log"
	"net/http"
)

func main() {
	port := config.GoDotEnvVariable("PORT")
	router := chi.NewRouter()

	router.Post("/signin", user.Signin)
	router.Get("/welcome", user.Welcome)
	router.Post("/refresh", user.Refresh)
	router.Post("/logout", user.Logout)
	router.Post("/register", user.Register)

	err := http.ListenAndServe(port, router)
	if err != nil {
		log.Println(err)
	}

}
