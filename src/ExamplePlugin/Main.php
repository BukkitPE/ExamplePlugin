<?php

namespace ExamplePlugin;

use BukkitPE\plugin\PluginBase;
use BukkitPE\event\Listener;
use BukkitPE\event\player\PlayerJoinEvent;

class Main extends PluginBase implements Listener{

public function onEnable() {
$this->getServer()->getPluginManager()->registerEvents($this, $this);
}

public function onJoin(PlayerJoinEvent $event){

$event->getPlayer()->sendMessage("Welcome to my server");  // this will send the player that joined the server the message inside the "()"
}
}
