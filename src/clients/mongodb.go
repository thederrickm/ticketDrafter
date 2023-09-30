package clients

import (
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"golang.org/x/crypto/bcrypt"
	"golang_ws_template/src/config"
	"golang_ws_template/src/models"
)

type Credentials struct {
	Password string `json:"password"`
	Username string `json:"username"`
}

func MongoDBUserCreate(creds models.Credentials) {
	client, err := mongo.Connect(context.TODO(), options.Client().ApplyURI(config.GoDotEnvVariable("MONGODB_URI")))
	if err != nil {
		panic(err)
	}
	defer func() {
		if err = client.Disconnect(context.TODO()); err != nil {
			panic(err)
		}
	}()
	coll := client.Database(config.GoDotEnvVariable("MDB_USER_DB")).Collection(config.GoDotEnvVariable("MDB_USER_CO"))

	hashedPassword, _ := bcrypt.GenerateFromPassword([]byte(creds.Password), 8)
	creds.Password = string(hashedPassword)

	result, err := coll.InsertOne(context.TODO(), creds)
	fmt.Printf("Inserted document with _id: %v\n", result.InsertedID)
}

func MongoDBUserFind(creds models.Credentials) models.Credentials {
	client, err := mongo.Connect(context.TODO(), options.Client().ApplyURI(config.GoDotEnvVariable("MONGODB_URI")))
	if err != nil {
		panic(err)
	}
	defer func() {
		if err = client.Disconnect(context.TODO()); err != nil {
			panic(err)
		}
	}()
	coll := client.Database(config.GoDotEnvVariable("MDB_USER_DB")).Collection(config.GoDotEnvVariable("MDB_USER_CO"))

	filter := bson.D{{"username", creds.Username}}
	var storedCreds models.Credentials
	err = coll.FindOne(context.TODO(), filter).Decode(&storedCreds)

	return storedCreds
}
