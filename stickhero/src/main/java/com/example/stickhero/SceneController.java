package com.example.stickhero;

public class SceneController {

        private static SceneController sceneController;

        private SceneController() {

        }

        public static SceneController getInstance() {

            if (sceneController == null) {
                sceneController = new SceneController();
                return sceneController;
            }
            return sceneController;
        }
}