package com.example.newsapp.data.local

import android.util.Log
import com.example.newsapp.data.remote.dtos.NewList.NewsListResponse
import com.google.gson.Gson
import kotlinx.coroutines.delay

class GetNewsListData {
    suspend fun getNewList() : NewsListResponse  {
        try {
            delay(3000)
            return Gson().fromJson(data, NewsListResponse::class.java)
        } catch (e: Exception) {
            Log.e("error" , "something went wrong ${e.message}")
        }

        return NewsListResponse(status = "NotOk")
    }

    val data = """
        {
          "status": "ok",
          "totalResults": 695,
          "articles": [
            {
              "source": {
                "id": null,
                "name": "CNET"
              },
              "author": "Kourtnee Jackson",
              "title": "Crunchyroll Review: Unmatched Simulcasts and Vast Catalog Set It Apart  CNET",
              "description": "Crunchyroll is a leading platform for streaming anime, despite some areas that could be enhanced.",
              "url": "https://www.cnet.com/tech/servicesandsoftware/crunchyrollreviewunmatchedsimulcastsandvastcatalogmakeitawinner/",
              "urlToImage": "data:image/jpeg;base64,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",
              "publishedAt": "20240310T16:00:08Z",
              "content": "For anime enthusiasts, there are multiple ways to watch anime in the US and internationally, but Crunchyroll has become a goto streaming service for fans to find the latest releases and beloved clas… [+15326 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "MacRumors"
              },
              "author": "Mitchel Broussard",
              "title": "Samsung's Spring Sale Expands With Big Discounts on Galaxy Smartphones, Watches, Tablets, and Laptops",
              "description": "This weekend, we're tracking a new sale at Samsung with savings on the company's best smartphones, smartwatches, tablets, and laptops. These discounts are part of Samsung's larger Discover Samsung Spring Sale, which we started covering last week with deals on…",
              "url": "https://www.macrumors.com/2024/03/10/samsungsspringsaleexpands/",
              "urlToImage": "https://c.ndtvimg.com/2024-06/8kv66lcs_neet-exam-protest_625x300_22_June_24.jpeg?downsize=516:320&w=516",
              "publishedAt": "20240310T14:37:44Z",
              "content": "This weekend, we're tracking a new sale at Samsung with savings on the company's best smartphones, smartwatches, tablets, and laptops. These discounts are part of Samsung's larger Discover Samsung Sp… [+2337 chars]"
            },
            {
              "source": {
                "id": "businessinsider",
                "name": "Business Insider"
              },
              "author": "Katherine TangalakisLippert,Lloyd Lee",
              "title": "Zuck roasts the Apple headset again",
              "description": "In a Threads post, Mark Zuckerberg slammed Apple's Vision Pro, saying Meta's Oculus Quest is better and the Apple headset is \"not what we aspire to.\"",
              "url": "https://www.businessinsider.com/markzuckerbergslamsapplevisionproagainmetaquestvr20243",
              "urlToImage": "https://c.ndtvimg.com/2024-06/trbnmngo_donald-trump_625x300_02_June_24.jpeg",
              "publishedAt": "20240310T04:28:16Z",
              "content": "Facebook CEO Mark Zuckerberg introduced the new Oculus Quest at the Facebook F8 Conference at McEnery Convention Center in San Jose, California.AMY OSBORNE via Getty Images\r\n<ul><li>Mark Zuckerberg h… [+2621 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xataka.com"
              },
              "author": "Javier Lacort",
              "title": "Hay rumores de que Apple está valorando lanzar un anillo inteligente. Tiene mucho sentido, pese al Apple Watch",
              "description": "El rumore rumore con el anillo inteligente de Apple viene de lejos, pero en estas últimas semanas se ha fortalecido gracias a una filtración de Mark Gurman en Bloomberg, quien confirmó que es uno de los productos sobre los que Apple está trabajando —lo cual n…",
              "url": "https://www.xataka.com/wearables/hayrumoresqueappleestavalorandolanzaranillointeligentetienemuchosentidopeseaquetengaapplewatch",
              "urlToImage": "https://c.ndtvimg.com/2024-06/oph4dfr_suryakumar-yadav-twitter_625x300_21_June_24.jpg?im=FeatureCrop,algorithm=dnn,width=806,height=605",
              "publishedAt": "20240310T10:00:53Z",
              "content": "El rumore rumore con el anillo inteligente de Apple viene de lejos, pero en estas últimas semanas se ha fortalecido gracias a una filtración de Mark Gurman en Bloomberg, quien confirmó que es uno de … [+3452 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xataka.com"
              },
              "author": "Enrique Pérez",
              "title": "Los 'satphones' son un nicho, pero los teléfonos con llamadas por satélite van a acabar en todas partes",
              "description": "Cada vez hay más satélites en órbita y ya hay móviles que lo aprovechan. Son los llamados 'satphones', aquellos con capacidad para realizar llamadas de voz aprovechando los satélites. El primero de estos teléfonos lo vimos en 2019 y su precio superaba los 1.2…",
              "url": "https://www.xataka.com/moviles/satphonesnichotelefonosllamadassatelitevanaacabartodaspartes",
              "urlToImage": "https://c.ndtvimg.com/2024-05/id2la3jo_gautam-gambhir-kkr-bcci_625x300_27_May_24.jpg?im=FeatureCrop,algorithm=dnn,width=806,height=605",
              "publishedAt": "20240310T18:00:52Z",
              "content": "Cada vez hay más satélites en órbita y ya hay móviles que lo aprovechan. Son los llamados 'satphones', aquellos con capacidad para realizar llamadas de voz aprovechando los satélites. El primero de e… [+3177 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xataka.com"
              },
              "author": "Yúbal Fernández",
              "title": "Cómo liberar espacio en tu cuenta de Google de forma rápida y sencilla con estos consejos básicos",
              "description": "Vamos a decirte varios métodos y trucos para liberar espacio en tu cuenta de Google. Es ahí donde se centraliza el almacenamiento disponible tanto para Google Drive como para Gmail, Google Fotos y el resto de aplicaciones nativas de Google o de terceros que h…",
              "url": "https://www.xataka.com/basics/comoliberarespaciotucuentagoogleformarapidasencillaestosconsejosbasicos",
              "urlToImage": "https://c.ndtvimg.com/2024-06/fjrlei9_kvaratskhelia_625x300_22_June_24.jpg?im=FeatureCrop,algorithm=dnn,width=806,height=605",
              "publishedAt": "20240310T13:00:54Z",
              "content": "Vamos a decirte varios métodos y trucos para liberar espacio en tu cuenta de Google. Es ahí donde se centraliza el almacenamiento disponible tanto para Google Drive como para Gmail, Google Fotos y el… [+6557 chars]"
            },
            {
              "source": {
                "id": "abcnews",
                "name": "ABC News"
              },
              "author": "ABC News",
              "title": "WATCH: Apple CEO Tim Cook talks 'Killers of the Flower Moon'",
              "description": "Tim Cook, CEO of Apple, discusses the Apple original film \"Killers of the Flower Moon,\" which is up for 10 Oscars tonight.",
              "url": "https://abcnews.go.com/Entertainment/video/appleceotimcooktalkskillersflowermoon107981576",
              "urlToImage": "https://i.abcnewsfe.com/a/ed070657617a497ca88e5cd813ceddcc/240310_abcnl_oscars_tim_cook_hpMain_16x9.jpg?w=992",
              "publishedAt": "20240310T21:31:27Z",
              "content": "<ul><li>Whats next for Russia? \r\n</li><li>What comes next after Texas school shooting?\r\n</li><li>What's next for abortion rights in America?\r\n</li><li>The new battle for voting rights\r\n</li><li>How w… [+2284 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Digital Trends"
              },
              "author": "Dan Girolamo",
              "title": "10 most Oscarnominated movies ever, ranked",
              "description": "From Titanic and La La Land to Oppenheimer and The Lord of the Rings: The Fellowship of the Ring, these are the 10 most Oscarnominated movies ever.",
              "url": "https://www.digitaltrends.com/movies/10mostoscarnominatedmoviesranked/",
              "urlToImage": "https://www.digitaltrends.com/wpcontent/uploads/2024/03/LeonardoDiCaprioandDannyNucciinTitanic1e1709838723800.jpg?resize=1200%2C630&p=1",
              "publishedAt": "20240310T12:15:07Z",
              "content": "Paramount Pictures\r\nThe Oscars are still the pinnacle of achievement for anyone working in movies. It’s not the beall and endall of success, however, it’s undeniable that an Oscar win elevates a fi… [+10818 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Digital Trends"
              },
              "author": "Phil Nickinson",
              "title": "The upcoming sports streaming service is a textbook case of a ‘trollout’",
              "description": "Information about a major new sports streaming service continues to be released in dribs and drabs, which doesn't really help anyone.",
              "url": "https://www.digitaltrends.com/hometheater/supersportsstreamingservicetrollout/",
              "urlToImage": "https://www.digitaltrends.com/wpcontent/uploads/2024/03/espnsports.jpg?resize=1200%2C630&p=1",
              "publishedAt": "20240310T14:30:03Z",
              "content": "Phil Nickinson / Digital Trends\r\nThere’s a phenomenon in the phone world that’s as smart as it is frustrating. That’s the one where a company announces an exciting new feature, only to eventually not… [+4309 chars]"
            },
            {
              "source": {
                "id": "bbcnews",
                "name": "BBC News"
              },
              "author": "https://www.facebook.com/bbcnews",
              "title": "Apple 'like Godfather' with new App Store rules",
              "description": "As Apple begins to allow other app stores on iPhones one entrepreneur criticises its behaviour.",
              "url": "https://www.bbc.co.uk/news/technology68517246",
              "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/156F5/production/_132879778_e1a592cfc09f4c1686e7a7b459c3c0dd.jpg",
              "publishedAt": "20240310T00:49:42Z",
              "content": "This week Apple made the longawaited landmark move to allow other companies to launch app stores on iPhones.\r\nThe tech giant was forced to act by EU lawmakers concerned about it having a market mono… [+5852 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Scarletink.com"
              },
              "author": "Dave Anderson",
              "title": "Technical Skills Are Overrated. Focus on Your Attitude",
              "description": "When interviewing, particularly for technical positions, many people over value their technical preparation, and don't consider the importance of personality and leadership preparation.",
              "url": "https://www.scarletink.com/p/technicalskillsareoverratedfocusonyourattitude",
              "urlToImage": "https://substackcdn.com/image/fetch/w_1200,h_600,c_fill,f_jpg,q_auto:good,fl_progressive:steep,g_auto/https%3A%2F%2Fsubstackpostmedia.s3.amazonaws.com%2Fpublic%2Fimages%2F0bc4a7edb7cf4b559b32512015beb1ae_2000x1334.jpeg",
              "publishedAt": "20240310T17:06:11Z",
              "content": "I walked into the interview room, and an energetic young guy (well call him Chen) ran up to me and shook my hand frantically with both of his. He was interviewing for a software engineering position.… [+4311 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "heise online"
              },
              "author": "Nico Ernst",
              "title": "Zwangsverkauf von TikTok könnte Hunderte Milliarden Dollar kosten",
              "description": "In den USA gibt es laut Medienberichten Gespräche unter Unternehmern über einen Kauf von TikTok. Der könnte bald erzwungen werden.",
              "url": "https://www.heise.de/news/ZwangsverkaufvonTikTokkoennteHunderteMilliardenDollarkosten9650851.html",
              "urlToImage": "https://heise.cloudimg.io/bound/1200x1200/q85.pnglossy85.webplossy85.foil1/_wwwheisede_/imgs/18/4/5/5/4/3/6/6/shutterstock_63402482324a4da6aea5ab43f.jpg",
              "publishedAt": "20240310T16:56:00Z",
              "content": "Weil eine politische Entscheidung über die Zukunft von TikTok in den USA unmittelbar bevorsteht, überlegen einige Größen der TechBranche gemeinsam, wie ein möglicher Zwangsverkauf abgewickelt werden… [+2002 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "9to5Mac"
              },
              "author": "Arin Waichulis",
              "title": "Security Bite: Hackers breach CISA, forcing the agency to take some systems offline",
              "description": "The Cybersecurity and Infrastructure Security Agency (CISA) says two systems were hacked in February through vulnerabilities in Ivanti products. In response, the agency had to shut down both systems, which reportedly had critical ties to U.S. infrastructure.\n…",
              "url": "https://9to5mac.com/2024/03/10/securitybitehackersbreachcisaforcingtheagencytotakesomesystemsoffline/",
              "urlToImage": "https://i0.wp.com/9to5mac.com/wpcontent/uploads/sites/6/2024/03/maxresdefault.jpg?resize=1200%2C628&quality=82&strip=all&ssl=1",
              "publishedAt": "20240310T11:30:00Z",
              "content": "The Cybersecurity and Infrastructure Security Agency (CISA) says two systems were hacked in February through vulnerabilities in Ivanti products. In response, the agency had to shut down both systems,… [+3051 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "9to5Mac"
              },
              "author": "Bradley Chambers",
              "title": "Dear Tim, It’s time to get lost in the music",
              "description": "Dear Tim,\n\n\n\nI bought my first Apple product back in 2004, an HPbranded iPod. In 2005, I purchased a PowerBook G4 and have never looked back. I’ve been an Apple customer ever since, acquiring multiple iPhones, iPads, Apple TVs, and Apple Watches along the wa…",
              "url": "https://9to5mac.com/2024/03/10/deartimitstimetogetlostinthemusic/",
              "urlToImage": "https://i0.wp.com/9to5mac.com/wpcontent/uploads/sites/6/2024/03/bradleyunplug.jpg?resize=1200%2C628&quality=82&strip=all&ssl=1",
              "publishedAt": "20240310T14:00:00Z",
              "content": "Dear Tim,\r\nI bought my first Apple product back in 2004, an HPbranded iPod. In 2005, I purchased a PowerBook G4 and have never looked back. Ive been an Apple customer ever since, acquiring multiple … [+4584 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Genbeta.com"
              },
              "author": "Eva Rodriguez de Luis",
              "title": "Esta empresa ha vuelto a Windows tras pasar años en Mac: estas son sus razones",
              "description": "Hay quien dice que una vez das el paso a Apple, ya no hay vuelta atrás. Sin embargo, haberlos, haylos. Aplicado a la informática de escritorio, desde un punto de vista personal supone un cambio de hábitos importante, pero en un entorno empresarial pasar de ma…",
              "url": "https://www.genbeta.com/afondo/estaempresahavueltoawindowspasaranosmacestassusrazones",
              "urlToImage": "https://i.blogs.es/ad6c19/mac/840_560.jpeg",
              "publishedAt": "20240310T16:00:54Z",
              "content": "Hay quien dice que una vez das el paso a Apple, ya no hay vuelta atrás. Sin embargo, haberlos, haylos. Aplicado a la informática de escritorio, desde un punto de vista personal supone un cambio de há… [+2744 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Genbeta.com"
              },
              "author": "Bárbara Bécares",
              "title": "Las plataformas de streaming líderes en cada país, representadas en un fabuloso mapa",
              "description": "Netflix es la plataforma con más usuarios de España, aunque ha caído tanto en nuestro país, tras un año de muchos cambios, como a nivel global, sigue estando por encima de otras plataformas. Hace unos días publicábamos sus buenas cifras a nivel global.\n<! B…",
              "url": "https://www.genbeta.com/afondo/plataformasstreamingliderescadapaisrepresentadasfabulosomapa1",
              "urlToImage": "https://i.blogs.es/cb5f4d/capturadepantalla20240307alas13.57.591/840_560.jpeg",
              "publishedAt": "20240310T14:00:53Z",
              "content": "Netflix es la plataforma con más usuarios de España, aunque ha caído tanto en nuestro país, tras un año de muchos cambios, como a nivel global, sigue estando por encima de otras plataformas. Hace uno… [+2585 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Joythebaker.com"
              },
              "author": "Toby Rose",
              "title": "Let It Be Sunday, 457!",
              "description": "Hello, friends!\nWhat’s your hidden talent?\nEarlier this week I was chauffeuring my son and his friend around town when the other kid was talking about how his mom can make anything. Her own clothes! Furniture! Songs! And it’s true. His mom is very creative; I…",
              "url": "https://joythebaker.com/2024/03/hiddentalents/",
              "urlToImage": "https://joythebaker.com/wpcontent/uploads/2024/03/IMG_0516_VSCOscaled.jpeg",
              "publishedAt": "20240310T08:55:31Z",
              "content": "Hello, friends!\r\nWhats your hidden talent?\r\nEarlier this week I was chauffeuring my son and his friend around town when the other kid was talking about how his mom can make anything. Her own clothes!… [+2327 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "AppleInsider"
              },
              "author": "news@appleinsider.com (Charles Martin)",
              "title": "New iPads, Pencil, Magic Keyboard are still on the way",
              "description": "After the release of MacBook Air with M3, a report insists that updated iPad models are still on the way, accompanied by new accessories.Apple was expected to launch a number of new products in quick succession, with the MacBook Air and iPad Pro changes arriv…",
              "url": "https://appleinsider.com/articles/24/03/10/newipadspencilmagickeyboardarestillontheway",
              "urlToImage": "https://photos5.appleinsider.com/gallery/589021201150713818xlxl.jpg",
              "publishedAt": "20240310T14:48:35Z",
              "content": "After the release of MacBook Air with M3, a report insists that updated iPad models are still on the way, accompanied by new accessories.\r\nApple was expected to launch a number of new products in qui… [+3117 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "AppleInsider"
              },
              "author": "news@appleinsider.com (Chip Loder)",
              "title": "How to use Apple's Time Capsule for backups on a modern wireless network",
              "description": "Time Capsule was Apple's discontinued line of network backup products. This is how you could use one on a modern network.Apple Time CapsulesIn 2008 Apple introduced a product called Time Capsule, which combined a wireless AirPort Base Station and an internal …",
              "url": "https://appleinsider.com/articles/24/03/10/howtouseapplestimecapsuleforbackupsonamodernwirelessnetwork",
              "urlToImage": "https://photos5.appleinsider.com/gallery/58702120010ledetimecapsule1xl.jpg",
              "publishedAt": "20240310T17:25:47Z",
              "content": "Apple Time Capsules\r\nTime Capsule was Apple's discontinued line of network backup products. This is how you could use one on a modern network.\r\nIn 2008 Apple introduced a product called Time Capsule,… [+7618 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "CNET"
              },
              "author": "Lisa Eadicicco",
              "title": "Why iOS 18 Could Be a Bigger Deal Than the iPhone 16  CNET",
              "description": "Commentary: Everyone's waiting to see how Apple incorporates generative AI into the iPhone. iOS 18 could provide the answer.",
              "url": "https://www.cnet.com/tech/mobile/whyios18couldbeabiggerdealthantheiphone16/",
              "urlToImage": "https://www.cnet.com/a/img/resize/d5e6d8754491f0d56c13d7180dc8102271e8ddc5/hub/2024/02/07/2b9e39ce009e4b8caf54a2113420cddd/manyphonesiphonesthree6623.jpg?auto=webp&fit=crop&height=675&width=1200",
              "publishedAt": "20240310T12:00:21Z",
              "content": "Apple's annual software upgrades are always a big deal in the tech world. But that's truer than ever in 2024 as Apple is expected to sprinkle more AI into its upcoming iOS 18 software update, accordi… [+6698 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Yanko Design"
              },
              "author": "Sarang Sheth",
              "title": "Some Apple Vision Pros are cracking down the center. To understand why, look at the shape of the KitKat bar.",
              "description": "Some Apple Vision Pros are cracking down the center. To understand why, look at the shape of the KitKat bar.Feel free to call it the “Spatial KitKat Hypothesis”… The Apple Vision Pro wasn’t designed to bend, but when you’ve got two straps pulling on...",
              "url": "https://www.yankodesign.com/2024/03/10/someapplevisionprosarecrackingdownthecentertounderstandwhylookattheshapeofthekitkatbar/",
              "urlToImage": "https://www.yankodesign.com/images/design_news/2024/03/someapplevisionprosarecrackingdownthecentertounderstandwhylookattheshapeofthekitkatbar/apple_vision_pro_cracking_kitkat_1.jpg",
              "publishedAt": "20240310T23:30:16Z",
              "content": "Feel free to call it the “Spatial KitKat Hypothesis”…\r\nThe Apple Vision Pro wasn’t designed to bend, but when you’ve got two straps pulling on the massive headset from either side with a human head i… [+5105 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Journal du geek"
              },
              "author": "Journal du Geek",
              "title": "Le meilleur antivirus Mac est français, il profite aujourd’hui d’une remise dingue (60%)",
              "description": "Intego est un éditeur de logiciels d'origine française qui s'est spécialisé sur MacOS depuis plus de 25 ans. Ce dernier édite un antivirus mondialement réputé, exclusivement pour les ordinateurs d'Apple. Ce weekend, celuici profite justement d'une remise fo…",
              "url": "https://www.journaldugeek.com/bonplan/lemeilleurantivirusmacestfrancaisetilprofiteaujourdhuiduneremisedingue60/",
              "urlToImage": "https://www.journaldugeek.com/app/uploads/2024/03/Mac.jpg",
              "publishedAt": "20240310T07:47:11Z",
              "content": "Sur la marché des antivirus, un éditeur se démarque de la concurrence, en proposant une solution exclusivement développée pour les Mac. Il s’agit de Intego, une société à la base française, ayant auj… [+4499 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "A Beautiful Mess"
              },
              "author": "Elsie Larson",
              "title": "Cape Cod Cocktail",
              "description": "A Cape Cod cocktail is a Vodka Cranberry. It’s also sometimes called a Cape Codder. The name Cape Cod comes from East Coast town in Massachusetts which is famous for growing cranberries. More cranberry drinks: Cosmo, Washington Apple Shot, Cranberry Spritz, O…",
              "url": "https://abeautifulmess.com/capecodcocktail/",
              "urlToImage": "https://abeautifulmess.com/wpcontent/uploads/2024/02/CapeCodDrink.jpg",
              "publishedAt": "20240310T13:05:00Z",
              "content": "A Cape Cod cocktail is a Vodka Cranberry. It’s also sometimes called a Cape Codder. The name Cape Cod comes from East Coast town in Massachusetts which is famous for growing cranberries. \r\nMore cranb… [+3615 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Applesfera.com"
              },
              "author": "Jesús Quesada",
              "title": "OnePlus Watch 2 VS Apple Watch Series 9: te aconsejamos qué smartwatch elegir",
              "description": "El mercado de los relojes \"inteligentes\" ha sufrido un importante cambio en los últimos años. Wear OS, el sistema operativo desarrollado por Google para smartwatches, estaba estancado, sin recibir novedades importantes ni el apoyo de muchas marcas, pero eso h…",
              "url": "https://www.applesfera.com/seleccion/onepluswatch2vsapplewatchseries9teaconsejamosquesmartwatchelegir",
              "urlToImage": "https://i.blogs.es/1b4906/applewatchseries9vsonepluswatch2/840_560.jpeg",
              "publishedAt": "20240310T18:00:52Z",
              "content": "El mercado de los relojes \"inteligentes\" ha sufrido un importante cambio en los últimos años. Wear OS, el sistema operativo desarrollado por Google para smartwatches, estaba estancado, sin recibir no… [+9127 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Applesfera.com"
              },
              "author": "Pedro Aznar",
              "title": "Es posible \"ver\" el código fuente de Matrix en nuestra realidad gracias a Apple Vision Pro. Nos dice mucho de su tecnología y futuro.",
              "description": "Es probablemente un momento muy similar al que vivimos con la llegada del primer iPhone. Me refiero al lanzamiento de Apple Vision Pro (de momento, sólo en Estados Unidos), que está fomentando la aparición de nuevas aplicaciones que aprovechan las capacidades…",
              "url": "https://www.applesfera.com/curiosidades/posiblevercodigofuentematrixnuestrarealidadgraciasaapplevisionpronosdicemuchosutecnologiafuturo",
              "urlToImage": "https://i.blogs.es/3342bd/matrixvisionproapp002/840_560.jpeg",
              "publishedAt": "20240310T19:00:00Z",
              "content": "Es probablemente un momento muy similar al que vivimos con la llegada del primer iPhone. Me refiero al lanzamiento de Apple Vision Pro (de momento, sólo en Estados Unidos), que está fomentando la apa… [+4656 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Applesfera.com"
              },
              "author": "Isra Fdez",
              "title": "Qué significan los iconos, colores y errores que aparecen en la pantalla de los Apple Vision Pro",
              "description": "Aunque todavía no están disponibles para comprar en España, los Vision Pro se han convertido en el dispositivo más sorprendente de 2024. En la actualidad, sus capacidades técnicas son inimitables y ya son el rival a batir tanto en realidad virtual como realid…",
              "url": "https://www.applesfera.com/nuevo/quesignificaniconoscoloreserroresqueaparecenpantallaapplevisionpro",
              "urlToImage": "https://i.blogs.es/029303/alertadevisionpro/840_560.jpeg",
              "publishedAt": "20240310T11:00:53Z",
              "content": "Aunque todavía no están disponibles para comprar en España, los Vision Pro se han convertido en el dispositivo más sorprendente de 2024. En la actualidad, sus capacidades técnicas son inimitables y y… [+7854 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Applesfera.com"
              },
              "author": "Álvaro García M.",
              "title": "He reconvertido mi viejo Mac en algo que pondría los pelos de punta a Steve Jobs: un Windows para jugar",
              "description": "Tener un ordenador de adorno, salvo que sea uno icónico como el primer Mac no es algo que se me pase por la cabeza. Menos cuando me costó un buen dinero y hoy día sigue siendo funcional. Se trata de mi iMac de 21,5 pulgadas con un Intel iCore 7 que por culpa …",
              "url": "https://www.applesfera.com/tutoriales/hereconvertidomiviejomacalgoquepondriapelospuntaastevejobswindowsparajugar",
              "urlToImage": "https://i.blogs.es/63989e/macwindows1/840_560.jpeg",
              "publishedAt": "20240310T16:00:53Z",
              "content": "Tener un ordenador de adorno, salvo que sea uno icónico como el primer Mac no es algo que se me pase por la cabeza. Menos cuando me costó un buen dinero y hoy día sigue siendo funcional. Se trata de … [+6241 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "MakeUseOf"
              },
              "author": "Will Graf",
              "title": "How to Factory Reset Your MacBook or iMac",
              "description": "Here's what you need to do to wipe your Mac and revert all its settings to default.",
              "url": "https://www.makeuseof.com/factoryresetmac/",
              "urlToImage": "https://static1.makeuseofimages.com/wordpress/wpcontent/uploads/wm/2024/03/macosrecoveryscreenappearingonamacbookair.jpg",
              "publishedAt": "20240310T12:00:12Z",
              "content": "Key Takeaways\r\n<ul><li> Factory reset your Mac before you give it away or sell it to ensure none of your data is on it. </li><li> Modern macOS versions let you factory reset your Mac from the System … [+4439 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Pressecitron"
              },
              "author": "Pressecitron",
              "title": "Quel Mac choisir ? Comparatif (MacBook Air, MacBook Pro, iMac, Mac mini…)",
              "description": "Opter pour le meilleur Mac n'est pas le choix le plus aisé, vous en conviendrez au vu du nombre de modèles disponibles désormais. Certains, comme le MacBook Air et le MacBook Pro, se ressemblent beaucoup. Dans ce comparatif, nous faisons le point, fiches tech…",
              "url": "https://www.pressecitron.net/quelmacchoisircomparatifmacbookairmacbookproimacmacmini/",
              "urlToImage": "https://www.pressecitron.net/app/uploads/2024/03/quelmacchoisir.webp",
              "publishedAt": "20240310T19:00:06Z",
              "content": "Top 5 meilleurs Mac 2024 :\r\n<ol><li>MacBook Air</li><li>iMac</li><li>MacBook Pro</li><li>Mac mini</li><li>Mac Studio</li></ol>Les critères à comparer pour bien choisir son Mac aujourd’hui\r\nLe format\r… [+14546 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "XDA Developers"
              },
              "author": "Carsen Joenk",
              "title": "Best noisecanceling earbuds in 2024",
              "description": "A tiny but mighty way to shut out the world",
              "url": "https://www.xdadevelopers.com/bestnoisecancelingearbuds/",
              "urlToImage": "https://static1.xdaimages.com/wordpress/wpcontent/uploads/2022/12/linkbudssvswf1000xm4earbud.png",
              "publishedAt": "20240310T22:00:13Z",
              "content": "Most of us use headphones every day to block out the commuter din, to connect us on handsfree phone calls, to rev us up at the gym, and much more. While overear headphones are a great option for pa… [+3315 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Faz.net"
              },
              "author": "Andreas Platthaus",
              "title": "BücherPodcast vom Rheingau Literatur Festival: Stephanie Barts „Erzählung zur Sache“",
              "description": "Eine RAFTerroristin verstehen und beim Schreiben auf Distanz halten: Stephanie Bart stellt im Gespräch mit Andreas Platthaus beim Rheingau Literatur Festival ihr Buch „Erzählung zur Sache“ vor.",
              "url": "https://www.faz.net/podcasts/fazbuecherpodcast/stephaniebartimbuecherpodcastmiterzaehlungzursache19570254.html",
              "urlToImage": "https://media0.faz.net/ppmedia/aktuell/520562530/1.9557208/facebook_teaser/stephaniebart.jpg",
              "publishedAt": "20240310T04:01:00Z",
              "content": "Am 24. Mai 1972 explodierten zwei Bomben der RAF auf dem Heidelberger Gelände des Hauptquartiers der USArmee in Europa, drei Menschen starben. Mit dem Tag dieses Anschlags, an dem Gudrun Ensslin bet… [+1681 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Techdirt"
              },
              "author": "Leigh Beadon",
              "title": "Funniest/Most Insightful Comments Of The Week At Techdirt",
              "description": "This week, our first place winner on the insightful side Toom1275 with a comment about Missouri’s new speech police: Teaching kids the reality that trans people exist and are normal is no more grooming them than teaching kids that frogs exist is grooming them…",
              "url": "https://www.techdirt.com/2024/03/10/funniestmostinsightfulcommentsoftheweekattechdirt101/",
              "urlToImage": "https://www.techdirt.com/wpcontent/themes/techdirt/assets/images/tdrectlogowhite.png",
              "publishedAt": "20240310T19:00:00Z",
              "content": "from the talkitup dept\r\nThis week, our first place winner on the insightful side Toom1275 with a comment about Missouri’s new speech police:\r\nTeaching kids the reality that trans people exist and a… [+3168 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "CNET"
              },
              "author": "Scott Stein （CNET News） 翻訳校正： 川村インターナショナル",
              "title": "「iPad」2024年モデルはどうなる？これまでの予想と個人的な期待",
              "description": "2024年の「iPad」に関しては、有機EL搭載「iPad Pro」、12.9インチ「iPad Air」に加えて、エントリーレベルのiPadと「iPad mini」についてのうわさも流れている。本記事では、各モデルで予想される変更点と、米CNET記者がエントリーモデルに期待することなどを紹介する。",
              "url": "https://japan.cnet.com/article/35216155/",
              "urlToImage": "https://japan.cnet.com/storage/2024/03/08/9d3999b30552349790c30205888a6d7f/ipadprom22022keyboard_1280x960.jpg",
              "publishedAt": "20240310T22:30:00Z",
              "content": "2022iPadiPad ProELiPad Air\r\niPadAppleiPadiPadiPad mini\r\nCNETAppleiPadiPadOSmacOSiPadMacBookiPad ProAirMacAppleAppleiPadMacmacOS\r\niPadAppleiPad\r\nAppleiPadELiPad ProM2iPad Pro12.9LED1112.9EL\r\nAppleELGa… [+553 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Les Numériques"
              },
              "author": "Louis Paillat",
              "title": "Actualité : Le test des écouteurs true wireless Sennheiser Momentum True Wireless 4 a rejoint notre comparatif",
              "description": "Notre comparatif de 89 écouteurs true wireless accueille le test du Sennheiser Momentum True Wireless 4, disponible à partir de 299 €. Il vient en alternative de l'Apple AirPods Pro (2e génération) au prix de 245 €.",
              "url": "https://www.lesnumeriques.com/intraecouteurtruewireless/letestdesecouteurstruewirelesssennheisermomentumtruewireless4arejointnotrecomparatifn219335.html",
              "urlToImage": "https://cdn.lesnumeriques.com/optim/test/21/218977/a3360f69sennheisermomentumtruewireless4desecouteursunpeuenavancesurleurtemps__1200_630__16136928381774_wtmk.jpg",
              "publishedAt": "20240310T07:55:00Z",
              "content": "Il ny a certes rien à redire sur leurs prestations sonores, mais les Momentum True Wireless 4 accusent quelques lacunes qui les empêchent de briller véritablement. Sur le papier, les écouteurs de Sen… [+991 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Les Numériques"
              },
              "author": "lesnums",
              "title": "Actualité : PSGReims : comment regarder le match de Ligue 1 en streaming ?",
              "description": "Ce dimanche 10 mars, Paris affronte Reims dans un match de 25e journée de Ligue 1 Uber Eats. Voici comment voir le match en streaming.",
              "url": "https://www.lesnumeriques.com/evenementsportif/psgreimscommentregarderlematchdeligue1enstreamingn219309.html",
              "urlToImage": "https://cdn.lesnumeriques.com/optim/news/21/219309/b71d5f40psgreimscommentregarderlematchdeligue1enstreaming__1200_630__03720011087.jpg",
              "publishedAt": "20240310T10:30:00Z",
              "content": "Cette saison 20232024 de Ligue 1 Uber Eats, 80 % des rencontres sont retransmises sur la plateforme de streaming Prime Video. Le service d'Amazon s'est en effet offert sept matchs sur neuf de chaque… [+2894 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xatakamovil.com"
              },
              "author": "Fran León",
              "title": "El Apple Watch que no necesita tener el iPhone al lado para funcionar marca su mínimo histórico en esta tienda",
              "description": "El Apple Watch SE es el modelo de reloj inteligente de Apple más económico, aunque si te decantas por la versión GPS + Cellular tendrás que pagar un poco más. Aunque ahora, en PcComponentes, puedes conseguir este modelo en oferta, por 295 euros.\n<! BREAK 1 …",
              "url": "https://www.xatakamovil.com/ofertas/applewatchquenonecesitateneriphonealladoparafuncionarmarcasuminimohistoricoestatienda",
              "urlToImage": "https://i.blogs.es/28af15/ofertas_cpa_v3copia18/840_560.jpeg",
              "publishedAt": "20240310T10:00:53Z",
              "content": "El Apple Watch SE es el modelo de reloj inteligente de Apple más económico, aunque si te decantas por la versión GPS + Cellular tendrás que pagar un poco más. Aunque ahora, en PcComponentes, puedes c… [+1482 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xatakamovil.com"
              },
              "author": "Eduardo Marín",
              "title": "Convierte tu iPhone en un reloj de mesa con este truco de iOS 17",
              "description": "Con cada nueva versión de su sistema operativo iOS, Apple incorpora nuevas funciones dedicadas a hacernos la vida (digital) más fácil y a permitirnos aprovechar al máximo nuestros móviles. iOS 17 está lleno de novedades, y todavía siguen llegando mediante act…",
              "url": "https://www.xatakamovil.com/tutoriales/conviertetuiphonerelojmesaestetrucoios17",
              "urlToImage": "https://i.blogs.es/83290f/modorelojmesaiphone/840_560.png",
              "publishedAt": "20240310T13:00:54Z",
              "content": "Con cada nueva versión de su sistema operativo iOS, Apple incorpora nuevas funciones dedicadas a hacernos la vida (digital) más fácil y a permitirnos aprovechar al máximo nuestros móviles. iOS 17 est… [+3440 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Xatakamovil.com"
              },
              "author": "Eva Rodriguez de Luis",
              "title": "Ni Gcam ni App Store alternativa: lo que más envidio de Android como usuaria de iPhone es el filtro de llamadas de los Google Pixel",
              "description": "Desde hace años que la elección entre Android o iOS tiene que ver más con gusto que con funcionalidades e incluso creo que la personalización ya ha alcanzado el suficiente nivel como para que no sea determinante. Sí, Android sigue siendo más flexible y ni siq…",
              "url": "https://www.xatakamovil.com/movilysociedad/gcamappstorealternativaqueenvidioandroidcomousuariaiphonefiltrollamadasgooglepixel",
              "urlToImage": "https://i.blogs.es/203216/sp/840_560.jpeg",
              "publishedAt": "20240310T15:00:54Z",
              "content": "Desde hace años que la elección entre Android o iOS tiene que ver más con gusto que con funcionalidades e incluso creo que la personalización ya ha alcanzado el suficiente nivel como para que no sea … [+3175 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Omgubuntu.co.uk"
              },
              "author": "Joey Sneddon",
              "title": "Linux Kernel 6.8 Released, This is What’s New",
              "description": "After several solid months of development the Linux 6.8 kernel has been officially released. This kernel is of particular note to Ubuntu users as it’s the version chosen to ship in Ubuntu 24.04 LTS – i.e., as the GA kernel and thereby supported for the durati…",
              "url": "https://www.omgubuntu.co.uk/2024/03/linuxkernel68newfeatures",
              "urlToImage": "https://149366088.v2.pressablecdn.com/wpcontent/uploads/2024/03/linuxkernel68.jpg.jpg",
              "publishedAt": "20240310T21:24:23Z",
              "content": "After several solid months of development the Linux 6.8 kernel has been officially released.\r\nThis kernel is of particular note to Ubuntu users as it’s the version chosen to ship in Ubuntu 24.04 LTS … [+5123 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Rolling Stone"
              },
              "author": "John Lonsdale",
              "title": "How to Watch ‘Killers of the Flower Moon’ Online, Just in Time for the Oscars",
              "description": "Here's where to watch Martin Scorsese's Oscar nom 'Killers of the Flower Moon' starring Lily Gladstone, Leonardo DiCaprio, and Robert De Niro online.",
              "url": "http://www.rollingstone.com/productrecommendations/lifestyle/howtowatchkillersoftheflowermoononlinestream1234984625/",
              "urlToImage": "https://www.rollingstone.com/wpcontent/uploads/2024/03/watchkillersoftheflowermoononline.jpg?w=1600&h=900&crop=1",
              "publishedAt": "20240310T21:19:51Z",
              "content": "If you purchase an independently reviewed product or service through a link on our website, Rolling Stone may receive an affiliate commission.\r\nQuick Answer: Scorsese fans can watchKillers of the Flo… [+4296 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Caschys Blog"
              },
              "author": "Felix Frank",
              "title": "Roborock Qrevo MaxV: SaugWischRoboter mit rotierenden Mopps im Ersteindruck",
              "description": "Im Rahmen der CES 2024 hatte Roborock mit dem Qrevo MaxV und dem Q Revo Pro neue Saug und Wischroboter vorgestellt. Diese Modelle sind etwas unter der SReihe angesiedelt, kommen aber als Besonderheit mit rotierenden Wischmopps. Die Neuvorstellungen bringen …",
              "url": "https://stadtbremerhaven.de/roborockqrevomaxvsaugwischrobotermitrotierendenmoppsimersteindruck/",
              "urlToImage": "https://stadtbremerhaven.de/wpcontent/uploads/2024/03/RoborockQrevoMaxV_0660.jpeg",
              "publishedAt": "20240310T19:00:11Z",
              "content": "Im Rahmen der CES 2024 hatte Roborock mit dem Qrevo MaxV und dem Q Revo Pro neue Saug und Wischroboter vorgestellt. Diese Modelle sind etwas unter der SReihe angesiedelt, kommen aber als Besonderhe… [+10567 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Frandroid"
              },
              "author": "Guillaume Sonnet",
              "title": "La Société Générale offre une belle enveloppe de 160 € rien qu’en ouvrant un compte",
              "description": "Besoin de renflouer les caisses ? Changer de banque peut vous faire gagner jusqu'à 160 euros avec un premier compte carte et c'est chez la Société Générale que ça se passe en ce moment.",
              "url": "https://www.frandroid.com/bonsplans/1958504_lasocietegeneraleoffreunebelleenveloppede160erienquenouvrantuncompte",
              "urlToImage": "https://images.frandroid.com/wpcontent/uploads/2024/03/sg160eurosoffremars2024.jpg",
              "publishedAt": "20240310T08:21:15Z",
              "content": "Besoin de renflouer les caisses ? Changer de banque peut vous faire gagner jusqu'à 160 euros avec un premier compte carte et c'est chez la Société Générale que ça se passe en ce moment.\r\nLa SG (ancie… [+4021 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Quartz India"
              },
              "author": "Kyle Barr / Gizmodo",
              "title": "The new MacBook Air is closer to the Pro — but that's not necessarily a good thing",
              "description": "If I had to think of the tech I’ve used most often in my daytoday, I wouldn’t usually consider my phone first. If I ruminate long and hard enough, considering the number of personhours that go into my work, I would consider my 13inch M1powered MacBook Ai…",
              "url": "https://qz.com/applemacbookairm3reviewspecsperformance1851321613",
              "urlToImage": "https://i.kinjaimg.com/image/upload/c_fill,h_675,pg_1,q_80,w_1200/f02701a67fc04193c1cef07616f5c1e8.jpg",
              "publishedAt": "20240310T09:00:00Z",
              "content": "MacBook Air with M3 13 and 15Inch\r\nThe Macbook Air redesign from two years ago is still just as silent, slim, and comfortable as you expect, but you won't see a massive difference from M2.\r\nThe Mac… [+15471 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Yahoo Entertainment"
              },
              "author": "Daniel Howley",
              "title": "Apple MacBook Air 2024 review: The best keeps getting better",
              "description": "Apple's M3powered MacBook Air 13inch and 15inch promise strong performance and exceptional battery life.",
              "url": "https://finance.yahoo.com/news/applemacbookair2024reviewthebestkeepsgettingbetter150017212.html",
              "urlToImage": "https://s.yimg.com/ny/api/res/1.2/m3WqFBBn4Oa3.jZy0Nb7vQ/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD02NzU/https://s.yimg.com/os/creatruploadedimages/202403/cf45a5d0dd7e11ee9ff65a1e53e2f4b4",
              "publishedAt": "20240310T14:53:59Z",
              "content": "Apples (AAPL) MacBook Air is one of the best laptops on the market. From its stylish design to its powerful performance and longlasting battery, its hard to top what Apple has to offer. Well, except… [+5932 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "GSMArena.com"
              },
              "author": "Ivan",
              "title": "Nothing Phone (2a) is here, Galaxy A55 and A35 incoming, Week 10 in review",
              "description": "Welcome to your week 10 recap. The Nothing Phone (2a) is official after weeks of teasers. It has a classic Nothing design with a semitranslucent rear panel, three Glyph LED lights, and a horizontal dual camera that Nothing dubs the Eyes. The phone packs a cu…",
              "url": "https://www.gsmarena.com/nothing_phone_2a_is_here_galaxy_a55_and_a35_incoming_week_10_in_reviewnews61929.php",
              "urlToImage": "https://fdn.gsmarena.com/imgroot/news/24/03/week10inreview/952x498w6/gsmarena_000.jpg",
              "publishedAt": "20240310T21:31:01Z",
              "content": "Welcome to your week 10 recap. The Nothing Phone (2a) is official after weeks of teasers. It has a classic Nothing design with a semitranslucent rear panel, three Glyph LED lights, and a horizontal … [+2020 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "GSMArena.com"
              },
              "author": "Peter",
              "title": "UK deals: Nothing Phone (2a) goes on preorder, Honor 90 and Moto Razr 40 Ultra on sale",
              "description": "The Nothing Phone (2a) was announced this week – the first attempt at a midranger from the company. Nothing has been a stylish valueformoney brand since its inception and it’s quite clear with the (2a).\n\nThis £320 midranger packs a large 6.7” 120Hz AMOLED…",
              "url": "https://www.gsmarena.com/weekly_deals_nothing_phone_2a_goes_on_preorder_honor_90_and_moto_razr_40_ultra_on_salenews61923.php",
              "urlToImage": "https://fdn.gsmarena.com/imgroot/news/24/03/weeklydeals8/952x498w6/gsmarena_0000.jpg",
              "publishedAt": "20240310T18:31:01Z",
              "content": "The Nothing Phone (2a) was announced this week the first attempt at a midranger from the company. Nothing has been a stylish valueformoney brand since its inception and its quite clear with the (2… [+4224 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "01net.com"
              },
              "author": "Gabriel Manceau",
              "title": "Quels sont les meilleurs smartphones haut de gamme en 2024 ?",
              "description": "Si vous avez un budget confortable et que vous n'arrivez pas à choisir parmi les nombreux smartphones haut de gamme disponibles, vous êtes au bon endroit. On vous présente notre sélection des meilleurs téléphones « premium » du moment.",
              "url": "https://www.01net.com/actualites/meilleurssmartphoneshautdegamme.html",
              "urlToImage": "https://www.01net.com/app/uploads/2024/02/OnePlus128P1002505.jpg",
              "publishedAt": "20240310T08:09:11Z",
              "content": "Si vous avez un budget confortable et que vous n’arrivez pas à choisir parmi les nombreux smartphones haut de gamme disponibles, vous êtes au bon endroit. On vous présente notre sélection des meilleu… [+8745 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Smartworld.it"
              },
              "author": "Antonio Lepore",
              "title": "L'SSD interno di MacBook Air M3 base è più veloce del modello precedente",
              "description": "Apple recentemente ha lanciato il suo nuovo MacBook Air M3, che dovrebbe garantire performance migliori, WiFi 6E ed il supporto...\r\nL'articolo L'SSD interno di MacBook Air M3 base è più veloce del modello precedente sembra essere il primo su Smartworld.",
              "url": "https://www.smartworld.it/news/ssdmacbookairm3base.html",
              "urlToImage": "https://www.smartworld.it/images/2024/03/04/macbookairm310_1200x675.jpg",
              "publishedAt": "20240310T13:03:00Z",
              "content": "Apple recentemente ha lanciato il suo nuovo MacBook Air M3, che dovrebbe garantire performance migliori, WiFi 6E ed il supporto ai display esterni. Inoltre, la società di Cupertino avrebbe superato … [+1117 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Deadline"
              },
              "author": "jillg366",
              "title": "EU Competition Chief Margrethe Vestager At SXSW – “We Care About Safety In Physical Products, We Have Not Cared Enough” About Digital Risks",
              "description": "The Europe’s Margrethe Vestager, one of the world’s most powerful and proactive regulators, has made Europe a first mover in checking big tech for the public good and in the interest of competition. The head of the EU’s Competition Commission has developed ke…",
              "url": "http://deadline.com/2024/03/eucompetitioncommissionmargrethevestagersxswai1235852390/",
              "urlToImage": "https://deadline.com/wpcontent/uploads/2024/03/IMG_4066rotated.jpg?w=1024",
              "publishedAt": "20240310T21:16:09Z",
              "content": "The Europe’s Margrethe Vestager, one of the world’s most powerful and proactive regulators, has made Europe a first mover in checking big tech for the public good and in the interest of competition.\r… [+4124 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Netzpolitik.org"
              },
              "author": "Bianca Kastl",
              "title": "Degitalisierung: Dann fährt den Zug halt die KI",
              "description": "Mehr Automatisierung, weniger Probleme? – Gemeinfreiähnlich freigegeben durch unsplash.com Christian Lue\r\nWas wäre, wenn wir statt Lokführer*innen einfach KIs die Züge fahren lassen? Die würden niemals streiken und aufmucken, oder? Toll? Eine Idee, bei der d…",
              "url": "https://netzpolitik.org/2024/degitalisierungdannfaehrtdenzughaltdieki/",
              "urlToImage": "https://cdn.netzpolitik.org/wpupload/2024/03/stuttgart_bahnhof1200x675.jpg",
              "publishedAt": "20240310T09:13:11Z",
              "content": "Die heutige Ausgabe von Degitalisierung kann sich nach dieser streiklustigen Woche ja eigentlich nur mit Zügen beschäftigen. Genauer gesagt mit deren Digitalisierung. Aber vielleicht beschäftigt sich… [+10397 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Creative Bloq"
              },
              "author": "joe.foley@futurenet.com (Joseph Foley)",
              "title": "People forlornly recall when Apple used to put things in the box",
              "description": "Apple used to care (sob).",
              "url": "https://www.creativebloq.com/news/applethingsinbox",
              "urlToImage": "https://cdn.mos.cms.futurecdn.net/mzz3x6HUAVqTadWxjaaG2M120080.jpg",
              "publishedAt": "20240310T14:00:59Z",
              "content": "We've already heard a bunch of rumours about the iPhone 16, which we presume Apple will launch in September 2024. But while nothing of what we have heard can is guaranteed to be fact so far, there is… [+1412 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Fran Besora",
              "title": "Epic Games recupera su cuenta de desarrollador de Apple",
              "description": "Apple finalmente ha decidido volver a activar la cuenta de desarrollador de Epic Games tras haberla desactivado esta misma semana. Esto significa que la compañía detrás del famoso juego Fortnite podrá lanzar la Epic Games Store, un mercado alternativo al App …",
              "url": "https://www.lavanguardia.com/andro4all/apple/epicgamesrecuperasucuentadedesarrolladordeapple",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/fortniteiphone.jpg?width=1200",
              "publishedAt": "20240310T13:19:44Z",
              "content": "Epic Games podrá lanzar su propia tienda alternativa\r\nApple finalmente ha decidido volver a activar la cuenta de desarrollador de Epic Games tras haberla desactivado esta misma semana. Esto significa… [+1960 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Christian Collado",
              "title": "Se encuentra 200 Apple Watch hundidos en lagos gracias a su detector de metales",
              "description": "Si sales a nadar en aguas abiertas con tu Apple Watch, será mejor que tengas cuidado con la correa que utilizas. Esa es la recomendación de Darick Langos, el impulsor de una empresa de recuperación de objetos perdidos, que a lo largo de los últimos meses ha e…",
              "url": "https://www.lavanguardia.com/andro4all/apple/seencuentra200applewatchhundidosenlagosgraciasasudetectordemetales",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/applewatchesrescatadosdeunlago.jpg?width=1200",
              "publishedAt": "20240310T19:01:51Z",
              "content": "Algunos de los smartwatches encontrados y recuperados del fondo de los lagos\r\nSi sales a nadar en aguas abiertas con tu Apple Watch, será mejor que tengas cuidado con la correa que utilizas. Esa es l… [+2010 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Fran Besora",
              "title": "Cómo evitar la descarga de apps fuera del App Store en el iPhone",
              "description": "Apple ha lanzado recientemente la versión final de iOS 17.4, una versión muy importante al incluir, entre otras cosas, la posibilidad de descargar aplicaciones a través de tiendas de terceros alternativas al App Store. Una novedad que no es del agrado de todo…",
              "url": "https://www.lavanguardia.com/andro4all/apple/comoevitarladescargadeappsfueradelappstoreeneliphone",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/tiendasappdeterceros.jpg?width=1200",
              "publishedAt": "20240310T08:01:35Z",
              "content": "Cómo bloquear la descarga de apps fuera del App Store\r\nApple ha lanzado recientemente la versión final de iOS 17.4, una versión muy importante al incluir, entre otras cosas, la posibilidad de descarg… [+2450 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Fran Besora",
              "title": "En Japón, la mitad de los smartphone vendidos son iPhone",
              "description": "Apple es la clara dominadora en Estados Unidos. No hay quien pueda con la cuota de mercado de la compañía de la manzana mordida. Y es que allá donde vayas te encontrarás un iPhone, y es por eso que Apple se centra tanto en que las novedades siempre estén en E…",
              "url": "https://www.lavanguardia.com/andro4all/apple/enjaponlamitaddelossmartphonevendidossoniphone",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/iphone15japon.jpg?width=1200",
              "publishedAt": "20240310T14:31:20Z",
              "content": "El iPhone es el claro dominador en Japón\r\nApple es la clara dominadora en Estados Unidos. No hay quien pueda con la cuota de mercado de la compañía de la manzana mordida. Y es que allá donde vayas te… [+2238 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Fran Besora",
              "title": "MacBook Air M2 vs. MacBook Air M3: estas son todas las diferencias",
              "description": "Esta semana, Apple ha presentado el MacBook Air con procesador M3 y es natural que te preguntes si existen muchas diferencias respecto al MacBook Air con procesador M2. Por eso, a lo largo de este artículo, te vamos a contar todas las diferencias entre el Mac…",
              "url": "https://www.lavanguardia.com/andro4all/apple/macbookairm2vsmacbookairm3estassontodaslasdiferencias",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/macbookairconm3diferenciasm2.jpg?width=1200",
              "publishedAt": "20240310T11:31:35Z",
              "content": "MacBook Air M2 vs. MacBook Air M3\r\nEsta semana, Apple ha presentado el MacBook Air con procesador M3 y es natural que te preguntes si existen muchas diferencias respecto al MacBook Air con procesador… [+2170 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "La Vanguardia"
              },
              "author": "Christian Collado",
              "title": "Consiguen instalar Mac OS en una Nintendo DS. Lo mejor de todo es que funciona",
              "description": "¿Te acuerdas del prototipo de Mac con pantalla táctil que salió a la luz hace unos meses? El mismo youtuber que, en su día, nos mostró esta rareza, está de vuelta con otro de sus experimentos. En esta ocasión, ha conseguido instalar una versión clásica de Mac…",
              "url": "https://www.lavanguardia.com/andro4all/tecnologia/consigueninstalarmacosenunanintendodslomejordetodoesquefunciona",
              "urlToImage": "https://www.lavanguardia.com/andro4all/hero/2024/03/macosenunanintendods.jpg?width=1200",
              "publishedAt": "20240310T16:31:22Z",
              "content": "Una Nintendo DS con macOS en su interior\r\n¿Te acuerdas del prototipo de Mac con pantalla táctil que salió a la luz hace unos meses? El mismo youtuber que, en su día, nos mostró esta rareza, está de v… [+1696 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Clubic"
              },
              "author": "Mérouan Goumiri",
              "title": "Apple ne va finalement pas supprimer le compte développeur d'Epic Games (Fortnite)",
              "description": "Contre toute attente, Apple vient d'annoncer qu'elle allait rétablir le compte développeur d'Epic Games. Par conséquent, Fortnite va prochainement pouvoir faire son grand retour sur iPhone.",
              "url": "https://www.clubic.com/actualite521146applenevafinalementpassupprimerlecomptedeveloppeurdepicgamesfortnite.html",
              "urlToImage": "https://pic.clubic.com/v1/images/2159974/raw",
              "publishedAt": "20240310T12:52:00Z",
              "content": "Le 6 mars dernier, soit le jour de l'entrée en vigueur du Digital Markets Act (DMA), Apple a banni le compte développeur d'Epic Games. Selon les nouvelles règles établies par la firme de Cupertino, l… [+543 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Clubic"
              },
              "author": "Maxence Glineur",
              "title": "DSA : Pornhub conteste le calcul de son nombre d'utilisateurs pour échapper à la réglementation européenne",
              "description": "Le géant du divertissement pour adultes ne veut pas être considéré comme une « très grande plateforme en ligne ». Et, pour bien le faire savoir, il se tourne vers la justice.",
              "url": "https://www.clubic.com/actualite521143dmapornhubcontestelenombredepersonnessursesplateformespourechapperalareglementationeuropeenne.html",
              "urlToImage": "https://pic.clubic.com/v1/images/2197051/raw",
              "publishedAt": "20240310T18:03:00Z",
              "content": "L'éditeur canadien a donc déposé un recours auprès du Tribunal de l'Union européenne le 1er mars dernier, expliquant au passage : « Nous pensons que la Commission européenne a commis une erreur dans … [+953 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Nextpit.de"
              },
              "author": "Benjamin Lucks",
              "title": "Die besten InEarKopfhörer mit ANC 2024 im Test und Vergleich",
              "description": "Ihr wollt Kopfhörer, die Euch mit gutem ANC versorgen? nextpit vergleicht die besten Kopfhörer von Sony, Bose und Apple mit aktiver Geräuschunterdrückung.",
              "url": "https://www.nextpit.de/diebesteninearkopfhoerermitanc2024imtestundvergleich",
              "urlToImage": "https://fscl01.fonpit.de/userfiles/7687254/image/Best_In_Ear_Headphones_2023.jpg",
              "publishedAt": "20240310T13:00:01Z",
              "content": "Die besten InEarKopfhörer 2023 im Vergleich\r\n<table><tr><td> </td><th>Beste InEars</th><th>Beste Alternative</th><th>Beste Audioqualität</th><th>Beste InEars von Apple</th><th>ANCChampion</th><t… [+23145 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "The Indian Express"
              },
              "author": "Vivek Umashankar",
              "title": "Apple Podcasts lets you read podcast transcripts in iOS 17.4: Here’s how it works",
              "description": "Apple Podcasts upgrades your experience with automatic transcripts. Discover how to follow along, jump to key points, and even share quotes with the latest iOS update.",
              "url": "https://indianexpress.com/article/technology/techook/applepodcaststranscripts9206297/",
              "urlToImage": "https://images.indianexpress.com/2024/03/applepodcaststranscriptsmain.jpg",
              "publishedAt": "20240310T11:00:23Z",
              "content": "With the release of the iOS 17.4 update, Apple has introduced a plethora of new features on eligible iPhones, including the introduction of autogenerated transcripts on Apple Podcasts.For Apple Podc… [+3012 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Googlewatchblog.de"
              },
              "author": "Jens",
              "title": "Pixel Watch 3: Endlich kommt ein größeres Display – Google behebt eine der größten Schwächen",
              "description": "Mit der Pixel Watch 3 geht Google die aus Nutzersicht größte Schwäche der Smartwatch an: Diese wird ein größeres Display erhalten.Pixel Watch 3: Endlich kommt ein größeres Display – Google behebt eine der größten SchwächenKeine GoogleNews mehr verpassen: Goo…",
              "url": "https://www.googlewatchblog.de/?p=221837",
              "urlToImage": "https://www.googlewatchblog.de/wpcontent/uploads/pixelwatchundgrossesmartwatch.jpg",
              "publishedAt": "20240310T07:30:07Z",
              "content": "In diesem Jahr wird Google schon die dritte Generation der PixelSmartwatch auf den Markt bringen, die als Pixel Watch 3 bereits ihre langen Schatten vorauswirft. Die ersten Leaks verraten uns, dass … [+4458 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Googlewatchblog.de"
              },
              "author": "Jens",
              "title": "Android: Microsoft schmeißt das gesamte AndroidÖkosystem aus Windows 11 – warum gerade jetzt?",
              "description": "Microsoft zieht Android unter Windows 11 den Stecker  aber warum gerade jetzt?Android: Microsoft schmeißt das gesamte AndroidÖkosystem aus Windows 11 – warum gerade jetzt?Keine GoogleNews mehr verpassen: GoogleWatchBlog bei Google News abonnieren",
              "url": "https://www.googlewatchblog.de/2024/03/androidmicrosoftoekosystemwindows11/",
              "urlToImage": "https://www.googlewatchblog.de/wpcontent/uploads/microsoftandroid1.jpg",
              "publishedAt": "20240310T06:00:52Z",
              "content": "Microsoft hat über einen langen Zeitraum daran gearbeitet, eine Brücke zwischen den AndroidSmartphones und Windows zu schaffen, zu der seit einiger Zeit auch die Nutzung von AndroidApps auf dem Win… [+3383 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Nextpit.de"
              },
              "author": "Edwin Kee",
              "title": "Top 5 Android & iOSApps der Woche: Golf, Workouts, Rezepte und mehr!",
              "description": "Mit diesen fünf besten Apps der Woche, die wir im Apple App Store und im Google Play Store gefunden haben, könnt Ihr Euer Wochenende richtig genießen.",
              "url": "https://www.nextpit.de/top5androidiosappsderwoche202410",
              "urlToImage": "https://fscl01.fonpit.de/userfiles/7687254/image/Top_Apps.jpg",
              "publishedAt": "20240310T09:00:00Z",
              "content": "Wirf einen Blick auf die Liste der Apps, die diese Woche im Angebot sind. Hermit verwandelt Webseiten in eigenständige Apps und ermöglicht so einen schnellen und einfachen Zugriff, während Whispp ein… [+9290 chars]"
            },
            {
              "source": {
                "id": "espn",
                "name": "ESPN"
              },
              "author": "Brianna Williams",
              "title": "Top antics from the 'Villanova Knicks': Jalen Brunson, Josh Hart and Donte DiVincenzo",
              "description": "The three pros shared the court together at Villanova, and have had a blast doing so in the NBA as well. Here are their top moments so far.",
              "url": "https://www.espn.com/nba/story/_/id/39680432/jalenbrunsonjoshhartdontedivincenzoknicksvillanovaantics",
              "urlToImage": "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0308%2Fr1301784_1296x729_16%2D9.jpg",
              "publishedAt": "20240310T14:41:23Z",
              "content": "Planning a trip with a group of friends can be challenging enough, but the New York Knicks might have the blueprint.\r\nEditor's Picks\r\nLed by college teammatesturnedfriendsturnedNBA teammates, Jal… [+3107 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Tomshw.it"
              },
              "author": "Andrea Maiellano",
              "title": "Nvidia scalza i giganti grazie all'IA, supera Amazon e punta alla vetta",
              "description": "Nvidia ha raggiunto il terzo posto nella classifica mondiale delle aziende più valutate, superando Saudi Aramco, e cercando di sorpassare Apple per raggiungere la seconda posizione.\nSecondo qu...",
              "url": "https://www.tomshw.it/hardware/nvidiascalzaigigantigraziealliasuperaamazonepuntaallavetta",
              "urlToImage": "https://www.tomshw.it/storage/media/2023/10/2387/Zuqr4BxnUNH5WyEz5JQPgF120080png.webp",
              "publishedAt": "20240310T09:56:52Z",
              "content": "Nvidia ha raggiunto il terzo posto nella classifica mondiale delle aziende più valutate, superando Saudi Aramco, e cercando di sorpassare Apple per raggiungere la seconda posizione.\r\nSecondo quanto r… [+2546 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Techbang.com"
              },
              "author": "cnBeta",
              "title": "搭配microLED的Apple Watch Ultra可能已夭折，原因是成本太高賺不到錢",
              "description": "傳聞中配備microLED的Apple Watch Ultra可能已夭折 歐司朗股價大跌四成\n據傳蘋果突然取消了被認為是用於Apple Watch Ultra的microLED顯示器訂單，導致歐司朗（ams Osram）的股價下跌了40%。\n雖然歐司朗和蘋果公司都沒有證實這家奧地利公司是下一代 Apple Watch Ultra 的微型 LED 螢幕供應商，但該公司此前曾與蘋果公司有過聯絡，並在 2023年發佈公告稱，2025年該公司的收入將有所增加，令外界預計屆時蘋果公司將推出採用該技術的 Apple Watc…",
              "url": "https://www.techbang.com/posts/113524microledapplewatchultra",
              "urlToImage": "https://cdn1.techbang.com/system/excerpt_images/113524/original/b407c50f2038a242d220c075cd10d244.jpg?1709535169",
              "publishedAt": "20240310T01:30:00Z",
              "content": "Apple Watch UltramicroLEDams Osram40%\r\n Apple Watch Ultra LED 20232025 Apple Watch Ultra 3\r\nams Osram microLED SIX Swiss Exchange\r\n Aldo Kamper 14.1 \r\n Rainer Irle Irle \r\n 2024 microLED 6.5 9.7 \r\n 40… [+236 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "B9.com.br"
              },
              "author": "Juliana Vilhena Nascimento",
              "title": "SXSW 2024 – (MAIS) Um tsunami vem aí",
              "description": "Amy Webb, Whurley e o MIT Tech Review concordam: não há momento melhor para se estar vivo do que o atual. Aliás, me impressionou o tanto de coisas em comum que estas três palestras trouxeram. Amy e o MIT trouxeram conteúdos densos, profundos e mais uma vez um…",
              "url": "https://www.b9.com.br/167032/sxsw2024maisumtsunamivemai/",
              "urlToImage": "https://assets.b9.com.br/wpcontent/uploads/2024/03/amywebb_sxsw2024.jpg",
              "publishedAt": "20240310T03:38:46Z",
              "content": "Amy Webb, Whurley e o MIT Tech Review concordam: não há momento melhor para se estar vivo do que o atual.\r\nAliás, me impressionou o tanto de coisas em comum que estas três palestras trouxeram. Amy e … [+3427 chars]"
            },
            {
              "source": {
                "id": "marca",
                "name": "Marca"
              },
              "author": "BAZAR",
              "title": "Los chollos de la semana en Amazon: la camiseta de Bellingham con descuentazo, unas zapatillas Nike casi a mitad de precio...",
              "description": "En Amazon podemos encontrar productos con una excelente relación calidadprecio, comentarios positivos de los usuarios... y a muy buen precio. Entre ellos, destacamos desde ideas m",
              "url": "https://www.marca.com/regalospromociones/2024/03/10/65ec9b2322601d12488b4577.html",
              "urlToImage": "https://phantommarca.unidadeditorial.es/2a3166c519d20da15e51de7b41233a25/resize/1200/f/webp/assets/multimedia/imagenes/2024/03/10/17100264461306.png",
              "publishedAt": "20240310T09:52:55Z",
              "content": "En Amazon podemos encontrar productos con una excelente relación calidadprecio, comentarios positivos de los usuarios... y a muy buen precio. Entre ellos, destacamos desde ideas muy prácticas para e… [+66411 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Gizmodo.com"
              },
              "author": "Rhett Jones",
              "title": "La mejor aplicación de todos los tiempos Día 10: Skype vs. Duolingo",
              "description": "¡Es el décimo día del desafío March Madness de Gizmodo para nombrar la mejor aplicación de todos los tiempos! SwiftKey realizó una sorpresa ayer, eliminando Telegram y avanzando a la siguiente ronda. Hoy, tenemos dos aplicaciones que no reciben mucha atención…",
              "url": "https://es.gizmodo.com/lamejoraplicaciondetodoslostiemposskypeduoling1851323738",
              "urlToImage": "https://i.kinjaimg.com/image/upload/c_fill,h_675,pg_1,q_80,w_1200/dff7c05cce7309ee327e697d966f9a44.jpg",
              "publishedAt": "20240310T17:00:00Z",
              "content": "¡Es el décimo día del desafío March Madness de Gizmodo para nombrar la mejor aplicación de todos los tiempos! SwiftKey realizó una sorpresa ayer, eliminando Telegram y avanzando a la siguiente ronda.… [+3647 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Ascii.jp"
              },
              "author": "ASCII",
              "title": "マツダの売れ筋SUV「CX5」の中で「FIELD JOURNEY」をオススメしたい理由",
              "description": "マツダでイチバン売れていると言われているのが「CX5」。それゆえ、グレード展開が多く、何を選んだらいいのかわからない。そんな人に「買うならFIELD JOURNEYのディーゼルエンジン仕様しかない」と提案します。",
              "url": "https://weekly.ascii.jp/elem/000/004/188/4188452/",
              "urlToImage": "https://ascii.jp/img/2024/03/08/3699136/l/be9a94411b3f4702.jpg",
              "publishedAt": "20240310T03:00:00Z",
              "content": "CX5 XD FIELD JOURNEY3839000\r\nSUVCX5\r\nFIELD JOURNEY\r\nFIELD JOURNEY\r\nCX5FIELD JOURNEY2021HP\r\nCX5FIELD JOURNEY\r\nSUV\r\nCX5 XD FIELD JOURNEY\r\nCX54575×1845×1690mmFIELD JOURNEY\r\nMiDRIVE\r\nOFFROAD\r\nMi… [+180 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Corriere.it"
              },
              "author": "Giacomo Fasola",
              "title": "Le serie tv da vedere questa settimana: Manhunt, Endless Love e Bandidos",
              "description": "Tra le nuove uscite anche Mano De Hierro e Young Royals 3, entrambe su Netflix",
              "url": "https://www.corriere.it/spettacoli/cinemaserietv/24_marzo_10/serietvdavederenetflixamazonskyraib3133cc0daee11ee96bed6d12839d1dd.shtml",
              "urlToImage": "https://images2.corriereobjects.it/methode_image/socialshare/2024/03/05/b5a34362daef11ee96bed6d12839d1dd.jpg",
              "publishedAt": "20240310T10:15:35Z",
              "content": "di Giacomo FasolaTra le nuove uscite anche Mano De Hierro e Young Royals 3, entrambe su Netflix\r\nManhunt (da venerdì 15 marzo su Apple TV+) \r\nIl libro Manhunt: The 12Day Chase for Lincoln’s Killer, … [+3495 chars]"
            },
            {
              "source": {
                "id": "techradar",
                "name": "TechRadar"
              },
              "author": "David Nield",
              "title": "The watchOS 10.4 update promises to fix the 'ghost touch' issue on the Apple Watch",
              "description": "Some Apple Watch users had been reporting false touches on the screen, but Apple has sorted it.",
              "url": "https://www.techradar.com/healthfitness/smartwatches/thewatchos104updatepromisestofixtheghosttouchissueontheapplewatch",
              "urlToImage": "https://cdn.mos.cms.futurecdn.net/TAcF46Wv25vapAJyMwh8aY120080.jpg",
              "publishedAt": "20240310T17:30:01Z",
              "content": "If you've noticed 'ghost touches' on your Apple Watch 9 or Apple Watch Ultra 2 – where something happens on the watch without you touching the screen – installing the latest watchOS 10.4 update shoul… [+1773 chars]"
            },
            {
              "source": {
                "id": "techradar",
                "name": "TechRadar"
              },
              "author": "amelia.schwanke@futurenet.com (Amelia Schwanke)",
              "title": "Millie Bobby Brown's new Netflix movie Damsel is a dud – watch these 3 great fantasy movies instead",
              "description": "Critics don't think Netflix's Damsel movie is worth saving – here are three better rated fantasy films to watch instead.",
              "url": "https://www.techradar.com/streaming/netflix/milliebobbybrownsnewnetflixmoviedamselisadudwatchthese3greatfantasymoviesinstead",
              "urlToImage": "https://cdn.mos.cms.futurecdn.net/kH9hmGmFVEgTB3A3xnr4nj120080.jpeg",
              "publishedAt": "20240310T09:00:54Z",
              "content": "Millie Bobby Brown's latest Netflix venture Damsel, in which the Stranger Things' actor faces a fiery showdown with a dragon, is proving to be truly in distress after early reviews call it a flop. Th… [+3001 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "David Phelan, Senior Contributor, \n David Phelan, Senior Contributor\n https://www.forbes.com/sites/davidphelan/",
              "title": "Apple Suddenly Confirms New iPhone Update’s Controversial Surprise",
              "description": "The latest iPhone software has an unwelcome surprise for some users and Apple has just revealed more details.",
              "url": "https://www.forbes.com/sites/davidphelan/2024/03/10/applesuddenlyconfirmsnewiphoneupdatescontroversialsurprise/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/6595c48e88c659d5565ce984/0x0.jpg?format=jpg&crop=2309,1298,x0,y212,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T17:04:28Z",
              "content": "Apples latest iPhone software, iOS 17.4 is just out and comes with plenty of feature updates. But in a development to be filed under unintended consequences, a surprise detail emerged for EU users wa… [+6301 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Ewan Spence, Senior Contributor, \n Ewan Spence, Senior Contributor\n https://www.forbes.com/sites/ewanspence/",
              "title": "Forget The New MacBook Pro, Apple Has Something Much Better",
              "description": "The iconic MacBook Pro may be the laptop many lust after, but the power of Apple Silicon means consumers should ignore this laptop and look elsewhere.",
              "url": "https://www.forbes.com/sites/ewanspence/2024/03/10/applemacbookairm3macbookproapplemacosdocknewmacbookupgrade/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/648494c39310479072750fc7/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T19:04:49Z",
              "content": "Updated March 10: article originally posted March 9.\r\nThe iconic MacBook Pro may be the laptop many lust after, but the power of Apple Silicon means consumers should ignore this laptop and look elsew… [+3285 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Ewan Spence, Senior Contributor, \n Ewan Spence, Senior Contributor\n https://www.forbes.com/sites/ewanspence/",
              "title": "New iPhone 16 Leak Reveals Apple’s Stunning Design Decision",
              "description": "It appears that Apple has decided on the look of the next iPhone, and it's going to change how you use your iPhone forever.",
              "url": "https://www.forbes.com/sites/ewanspence/2024/03/10/ppleiphone16cameraspecsleakdesignnewiphone/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65ec6f08ad991bda12b6b969/0x0.jpg?format=jpg&crop=1954,1099,x266,y120,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T17:37:48Z",
              "content": "Updated March 10: article originally posted March 9.\r\nIt appears that Apple has decided on the look of the next iPhone. The latest leaked CAD files claim to show the final design decision. And theres… [+3414 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Zak Doffman, Contributor, \n Zak Doffman, Contributor\n https://www.forbes.com/sites/zakdoffman/",
              "title": "Google’s Surprise Update Just Made Android More Like iPhone",
              "description": "Why you need Android’s latest update on your phone…",
              "url": "https://www.forbes.com/sites/zakdoffman/2024/03/10/googleupgradesamsungs24s23pixeltowardsappleiphone15promax/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65aeed369be3a016e61b4a9a/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T15:32:41Z",
              "content": "There is little to choose between premium Samsung or Apple or even Google smartphones these days. Its the iPhone versus Android operating systems that set them apart. Now thats changing as welland Go… [+5850 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Energy Innovation: Policy and Technology, Contributor, \n Energy Innovation: Policy and Technology, Contributor\n https://www.forbes.com/sites/energyinnovation/",
              "title": "Right To Repair: Making Products Last Longer Saves Money And The Climate",
              "description": "What are the benefits for a good right to repair law? Saving consumers money and helping the environment.",
              "url": "https://www.forbes.com/sites/energyinnovation/2024/03/10/righttorepairmakingproductslastlongersavesmoneyandtheclimate/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65ea155640360554064be50f/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T12:30:00Z",
              "content": "Nik Sawe is a Policy Analyst, Industry at Energy Innovation, a nonpartisan energy and climate policy think tank. Energy Innovations new book, ZeroCarbon Industry, is the definitive guide to the brea… [+8145 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Brad Japhe, Senior Contributor, \n Brad Japhe, Senior Contributor\n https://www.forbes.com/sites/bradjaphe/",
              "title": "The World’s Best Bourbon—According To The 2024 American Craft Spirits Competition",
              "description": "This unapologetically aggressive Texas whiskey can be bottled as high as 140.9proof.",
              "url": "https://www.forbes.com/sites/bradjaphe/2024/03/10/theworldsbestbourbonaccordingtothe2024americancraftspiritscompetition/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65ecb7345c0a8fad1bc06d6c/0x0.jpg?format=jpg&crop=759,426,x6,y0,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T08:30:00Z",
              "content": "Barrel strength Cowboy Bourbon from Garrison Brothers distillery out of Hye, Texas\r\nPhoto Illustration: Brad Japhe\r\nThe American Craft Spirits Association just announced the results of its 10th annua… [+3314 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Mark Sparrow, Senior Contributor, \n Mark Sparrow, Senior Contributor\n https://www.forbes.com/sites/marksparrow/",
              "title": "Saramonic Blink500 B2+ Is The Ideal And Most Affordable TikTok Mic",
              "description": "This handy wireless microphone kit from Saramonic is affordable and works like a charm. It's ideal for TikTRok and Instagram Reels.",
              "url": "https://www.forbes.com/sites/marksparrow/2024/03/10/saramonicblink500b2istheidealandmostaffordabletiktokmic/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65e8776104d43bb474dcbbc7/0x0.jpg?format=jpg&crop=1330,748,x83,y92,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T11:00:00Z",
              "content": "The Blink500 B2+ from Saramonic is a complete wireless microphone kit for making videos and ... [+] podcasts.\r\nSaramonic\r\nWho could have guessed that the rise of TikTok could have invigorated a secto… [+4779 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Zak Doffman, Contributor, \n Zak Doffman, Contributor\n https://www.forbes.com/sites/zakdoffman/",
              "title": "Beware—Do Not Click These Dangerous New Google Meet And Zoom Links",
              "description": "Online meetings just became a lot more dangerous...",
              "url": "https://www.forbes.com/sites/zakdoffman/2024/03/10/newwarningformicrosoftwindows11samsunggooglepixelusers/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65edbed6f688886a182d27d9/0x0.jpg?format=jpg&crop=2516,1328,x245,y12,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T14:45:00Z",
              "content": "We have all come to live with the endless succession of online meetings that dominate our working lives. But beware, some of those meetings might suddenly be more dangerous than you think...\r\nBewareo… [+4695 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Bill Stone, Contributor, \n Bill Stone, Contributor\n https://www.forbes.com/sites/bill_stone/",
              "title": "Does The Jobs Report Signal Recession And A June Fed Rate Cut?",
              "description": "A jobs report bolstered the case for a soft landing and a June Fed rate cut but inches toward triggering a recession warning. CPI and retail sales will be watched.",
              "url": "https://www.forbes.com/sites/bill_stone/2024/03/10/doesthejobsreportsignalrecessionandajunefedratecut/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65ec8aeeedd725302eb3bb61/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T11:00:00Z",
              "content": "The unemployment rate rose to 3.9%. Notably, the rise is inching closer to triggering s recession ... [+] indicator with an unblemished track record.\r\ngetty\r\nStocks took a slight hiatus, and the Magn… [+4421 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Felicity Carter, Contributor, \n Felicity Carter, Contributor\n https://www.forbes.com/sites/felicitycarter/",
              "title": "London’s Culture Crush: What To See, Do And Experience In March",
              "description": "From wellness activities to gardening workshops, here’s what to see and do in London this month.",
              "url": "https://www.forbes.com/sites/felicitycarter/2024/03/10/londonsculturecrushwhattoseedoandexperienceinmarch/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65de09e18886b67e9514ce03/0x0.jpg?format=jpg&crop=2260,1270,x0,y162,safe&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T12:45:36Z",
              "content": "LONDON, UNITED KINGDOM  Tower Bridge, The Tower of London and The Shard can be seen in this image, ... [+] taken by a drone from St Katharine Docks. (Photo by Chris Gorman/Getty Images)\r\nGetty Image… [+6549 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Forbes"
              },
              "author": "Steve Andriole, Contributor, \n Steve Andriole, Contributor\n https://www.forbes.com/sites/steveandriole/",
              "title": "StartUp Funding Declassified. Tips From The Trenches.",
              "description": "Remember that many technology venture capitalists (VCs) are selfassured because they have money to invest, because they’re rich and because entrepreneurs chase them.",
              "url": "https://www.forbes.com/sites/steveandriole/2024/03/10/startupfundingdeclassifiedtipsfromthetrenches/",
              "urlToImage": "https://imageio.forbes.com/specialsimages/imageserve/65ee270b4a77cca88f640e60/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
              "publishedAt": "20240310T23:03:36Z",
              "content": "light bulb taking off and releasing smoke. concept of idea explosion, learning, education and ... [+] startup. 3d rendering\r\ngetty\r\nHeres some unconventional if not a little passiveaggressive perspe… [+8728 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Tom's Hardware UK"
              },
              "author": "Anton Shilov",
              "title": "Extra NAND chip makes Apple MacBook Air M3 256GB SSD drastically faster than predecessor",
              "description": "Apple fixes SSD performance on the latest M3based MacBook Air laptops, but it is still not that fast.",
              "url": "https://www.tomshardware.com/laptops/macbooks/extranandchipmakesapplemacbookairm3256gbssddrasticallyfasterthanpredecessor",
              "urlToImage": "https://cdn.mos.cms.futurecdn.net/YNzYQ9cZmsqpRkWPALAg6h120080.jpg",
              "publishedAt": "20240310T15:36:34Z",
              "content": "Apple's entrylevel MacBook Air notebooks based on M2 processors were heavily criticized for their lowperformance solid state drives, as the company decided to cut costs and sacrifice parallelism. H… [+3378 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Tom's Hardware UK"
              },
              "author": "Mark Tyson",
              "title": "Compal Rover Play 2in1 PC offers foldout rear controller grips for gamers  wins an iF Design Award",
              "description": "An innovative new 2in1 gaming PC design features rear panels that can be articulated to form hand grips. Compal, a major PC and device ODM in Taiwan, is behind this gamerfocused concept which has recently won an iF Design Award.",
              "url": "https://www.tomshardware.com/laptops/gaminglaptops/compalroverplay2in1pcoffersfoldoutrearcontrollergripsforgamerswinsanifdesignaward",
              "urlToImage": "https://cdn.mos.cms.futurecdn.net/yRU3e4RfzC9EQwFAfzxC8i120080.jpg",
              "publishedAt": "20240310T14:25:12Z",
              "content": "An innovative new 2in1 laptop PC design features rear panels that can be articulated to form hand grips. Compal, a big PC and devices ODM in Taiwan, is behind this gamerfocused concept that has wo… [+2035 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Iphoneblog.de"
              },
              "author": "Alex Olma",
              "title": "Apple klickt den BrowserBackButton: Progressive Web Apps bleiben auch in der EU",
              "description": "Progressive Web Apps waren Mitte Februar der Aufreger; Anfang März rollte Apple zurück. Previously, Apple announced plans to remove the Home Screen web apps capability in the EU as part of our efforts to comply with the DMA. The need to remove the capability …",
              "url": "https://www.iphoneblog.de/2024/03/10/appleklicktdenbrowserbackbuttonprogressivewebappsbleibenauchindereu/",
              "urlToImage": "https://www.iphoneblog.de/wpcontent/uploads/2024/03/image10.3.202414.01.png",
              "publishedAt": "20240310T12:32:44Z",
              "content": "Progressive Web Apps waren Mitte Februar derAufreger; Anfang März rollte Apple zurück.\r\nPreviously, Apple announced plans to remove the Home Screen web apps capability in the EU as part of our effort… [+1659 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Antyweb.pl"
              },
              "author": "Kamil Świtalski",
              "title": "Czekam na powrót elektroniki w tej estetyce. Nie wszystko musi być stalowe, tytanowe i nudne",
              "description": "Podobno moda powraca. Mam cichą nadzieję, że ta na przeźroczyste obudowy w elektronice również jeszcze do nas zawita.\n \n The post Czekam na powrót elektroniki w tej estetyce. Nie wszystko musi być stalowe, tytanowe i nudne appeared first on AntyWeb.",
              "url": "https://antyweb.pl/czekamnapowrotelektronikiwtejestetyceniewszystkomusibycstalowetytanoweinudne",
              "urlToImage": "https://antyweb.pl/img/1250/550/fit/wpcontent/uploads/2024/02/sbo64j47m5/levimeirclancyjdIT3puximIunsplash.jpg",
              "publishedAt": "20240310T08:30:44Z",
              "content": "Z przekonaniami dotyczcymi designu jest jak z ulubion zup: kady ma swoj. Przez lata bylimy wiadkami tego jak zmienia si design w wiecie elektroniki. Daleki jestem od twierdzenia, e kiedy byo lepiej i… [+2742 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "iLounge"
              },
              "author": "Samantha Wiley",
              "title": "The 4Pack Apple AirTag is ${'$'}21 Off",
              "description": "Apple’s tracking device is so good that you can use it on almost anything. Today, the Apple AirTag 4Pack is down to just ${'$'}78.99 from its original price of ${'$'}100 on Amazon. Instead of a single AirTag, why not get a 4pack and a discount in the process? The ite…",
              "url": "https://www.ilounge.com/news/the4packappleairtagis21off",
              "urlToImage": "https://www.ilounge.com/wpcontent/uploads/2024/03/AppleAirTag.png",
              "publishedAt": "20240310T10:23:02Z",
              "content": "Apple’s tracking device is so good that you can use it on almost anything. Today, the Apple AirTag 4Pack is down to just ${'$'}78.99 from its original price of ${'$'}100 on Amazon.\r\nInstead of a single AirTag… [+650 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "iLounge"
              },
              "author": "Samantha Wiley",
              "title": "Epic’s developer account to be restored",
              "description": "Apple did a turnaround and has promised to restore the developer account of Epic Games in the EU. Epic recently disclosed that they could not guarantee following the App Store developer rules, and hence had their App Store developer account revoked. However, …",
              "url": "https://www.ilounge.com/news/apple/epicsdeveloperaccounttoberestored",
              "urlToImage": "https://www.ilounge.com/wpcontent/uploads/2024/03/Epic.png",
              "publishedAt": "20240310T10:16:01Z",
              "content": "Apple did a turnaround and has promised to restore the developer account of Epic Games in the EU.\r\nEpic recently disclosed that they could not guarantee following the App Store developer rules, and h… [+689 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "iLounge"
              },
              "author": "Samantha Wiley",
              "title": "New document outlines 30day thirdparty App Store restrictions",
              "description": "A support document spells out the limitations of third party app stores in EU. Apple published an online document, stating that EU customers will be able to download or purchase iPhone apps from third party app stores beginning March 7. The Cupertinobased co…",
              "url": "https://www.ilounge.com/news/newdocumentoutlines30daythirdpartyappstorerestrictions",
              "urlToImage": "https://www.ilounge.com/wpcontent/uploads/2024/03/AppStore.png",
              "publishedAt": "20240310T10:18:49Z",
              "content": "A support document spells out the limitations of third party app stores in EU.\r\nApple published an online document, stating that EU customers will be able to download or purchase iPhone apps from thi… [+699 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "iLounge"
              },
              "author": "Samantha Wiley",
              "title": "PayPal business Tap to Pay option now supported on iPhone",
              "description": "PayPal business users for Venmo and Zettle will now be able to offer Tap to Pay using their iPhones for taking payments. PayPal recently announced that US customers can now use Tap to Pay nationwide. Apple Pay support had been declared since September last ye…",
              "url": "https://www.ilounge.com/news/paypalbusinesstaptopayoptionnowsupportedoniphone",
              "urlToImage": "https://www.ilounge.com/wpcontent/uploads/2024/03/PayPal.png",
              "publishedAt": "20240310T10:21:14Z",
              "content": "PayPal business users for Venmo and Zettle will now be able to offer Tap to Pay using their iPhones for taking payments.\r\nPayPal recently announced that US customers can now use Tap to Pay nationwide… [+660 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Olhardigital.com.br"
              },
              "author": "Alessandro Di Lorenzo",
              "title": "Big techs investem mais em pesquisa do que todos os países da União Europeia juntos",
              "description": "Um estudo aponta que as regras aprovadas para combater o monopólio das big techs na União Europeia não bastam para reverter o quadro\nO post Big techs investem mais em pesquisa do que todos os países da União Europeia juntos apareceu primeiro em Olhar Digital.",
              "url": "https://olhardigital.com.br/2024/03/10/pro/bigtechsinvestemmaisempesquisadoquetodosospaisesdauniaoeuropeiajuntos/",
              "urlToImage": "https://olhardigital.com.br/wpcontent/uploads/2023/07/UniaoEuropeia695x500.jpg",
              "publishedAt": "20240310T16:05:00Z",
              "content": "Um estudo encomendado pela União Europeia aponta que as regras aprovadas para combater o monopólio das big techs não serão suficientes para alavancar a pesquisa e o desenvolvimento dentro do bloco. O… [+3437 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Olhardigital.com.br"
              },
              "author": "Rodrigo Mozelli",
              "title": "Jogos de hoje (10/03/24): onde assistir futebol ao vivo e horários das partidas",
              "description": "Confira horários e onde assistir ao vivo aos jogos de hoje (10/03/24) do futebol do Brasil e do mundo na TV e no streaming\nO post Jogos de hoje (10/03/24): onde assistir futebol ao vivo e horários das partidas apareceu primeiro em Olhar Digital.",
              "url": "https://olhardigital.com.br/2024/03/10/interneteredessociais/jogosdehoje100324ondeassistirfutebolaovivoehorariosdaspartidas/",
              "urlToImage": "https://olhardigital.com.br/wpcontent/uploads/2023/06/futebolstreaming695x500.jpg",
              "publishedAt": "20240310T11:00:00Z",
              "content": "Confira aqui no Olhar Digital onde assistir ao vivo às partidas de hoje, 10 de março de 2024. Veja a seguir os horários dos jogos de hoje, com atenção especial para as partidas dos campeonatos estadu… [+5315 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Olhardigital.com.br"
              },
              "author": "Kelvin Leão Nunes da Costa",
              "title": "Os 10 melhores filmes com Adam Driver",
              "description": "Adam Driver é considerado um dos atores mais famosos e talentosos de sua geração. Confira seus melhores papéis no cinema!\nO post Os 10 melhores filmes com Adam Driver apareceu primeiro em Olhar Digital.",
              "url": "https://olhardigital.com.br/2024/03/10/cinemaestreaming/os10melhoresfilmescomadamdriver/",
              "urlToImage": "https://olhardigital.com.br/wpcontent/uploads/2024/03/anette695x500.png",
              "publishedAt": "20240310T20:40:00Z",
              "content": "Reconhecido pelo público e pela crítica pelo seu talento, Adam Driver desponta como um dos mais importantes atores de sua geração em Hollywood. \r\nCom performances aclamadas em um número considerável … [+5931 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Olhardigital.com.br"
              },
              "author": "Bruno Capozzi",
              "title": "Oscar 2024: quem deve ganhar e quem poderia ganhar",
              "description": "Fizemos nossas apostas! Quem deve ganhar em cada categoria?\nO post Oscar 2024: quem deve ganhar e quem poderia ganhar apareceu primeiro em Olhar Digital.",
              "url": "https://olhardigital.com.br/2024/03/10/cinemaestreaming/oscar2024quemdeveganharequempoderiaganhar/",
              "urlToImage": "https://olhardigital.com.br/wpcontent/uploads/2023/03/oscar2023695x500.jpg",
              "publishedAt": "20240310T15:43:50Z",
              "content": "Falta pouco para a maior premiação do cinema! O Oscar 2024 acontece neste domingo. E o Olhar Digital fez suas apostas! Ok, não quero comprometer toda a equipe em caso de múltiplos erros. Então vou me… [+6508 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Osnews.com"
              },
              "author": "Thom Holwerda",
              "title": "The Apple curl security incident 12604",
              "description": "When this command line option is used with curl on macOS, the version shipped by Apple, it seems to fall back and checks the system CA store in case the provided set of CA certs fail the verification. A secondary check that was not asked for, is not documente…",
              "url": "https://www.osnews.com/story/138761/theapplecurlsecurityincident12604/",
              "urlToImage": null,
              "publishedAt": "20240310T13:09:21Z",
              "content": "When this command line option is used with curl on macOS, the version shipped by Apple, it seems to fall back and checks the system CA store in case the provided set of CA certs fail the verification… [+453 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "Osnews.com"
              },
              "author": "Thom Holwerda",
              "title": "House panel unanimously approves bill that could ban TikTok",
              "description": "A powerful House committee advanced a bill on Thursday that could lead to a nationwide ban against TikTok on all electronic devices, renewing lawmakers’ challenge to one of the world’s most popular social media apps and highlighting unresolved fears that TikT…",
              "url": "https://www.osnews.com/story/138756/housepanelunanimouslyapprovesbillthatcouldbantiktok/",
              "urlToImage": null,
              "publishedAt": "20240310T21:54:30Z",
              "content": "A powerful House committee advanced a bill on Thursday that could lead to a nationwide ban against TikTok on all electronic devices, renewing lawmakers challenge to one of the worlds most popular soc… [+959 chars]"
            },
            {
              "source": {
                "id": null,
                "name": "3dnews.ru"
              },
              "author": null,
              "title": "Самый дешёвый MacBook Air с чипом M3 получил более скоростной SSD, чем у предшественника",
              "description": "На этой неделе Apple представила обновлённые 13 и 15дюймовые ноутбуки MacBook Air, которые получили более мощные процессоры Apple M3. Теперь же стало известно, что вендор решил ещё одну проблему, которая беспокоила владельцев базовой версии MacBook Air пред…",
              "url": "https://3dnews.ru/1101471/obnovlyonniymacbookairschipomm3osnastiliboleebistrimnakopitelemssdchemupredshestvennika",
              "urlToImage": "https://3dnews.ru/assets/external/illustrations/2024/03/10/1101471/210.jpg",
              "publishedAt": "20240310T07:57:00Z",
              "content": "Apple 13 15 MacBook Air, Apple M3. , , MacBook Air . (SSD).\r\n: Apple\r\n, MacBook Air M2 256 256 , 128 , MacBook Air M1. MacBook Air M2 , SSD , .\r\n, MacBook Air M3 , . , , MacBook Air M3 256 NAND 128… [+100 chars]"
            }
          ]
        }
    """.trimIndent()
}