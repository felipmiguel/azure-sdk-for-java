// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.netapp.NetAppFilesManager;
import com.azure.resourcemanager.netapp.models.DailySchedule;
import com.azure.resourcemanager.netapp.models.HourlySchedule;
import com.azure.resourcemanager.netapp.models.MonthlySchedule;
import com.azure.resourcemanager.netapp.models.SnapshotPolicy;
import com.azure.resourcemanager.netapp.models.WeeklySchedule;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class SnapshotPoliciesCreateWithResponseMockTests {
    @Test
    public void testCreateWithResponse() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr =
            "{\"etag\":\"jid\",\"properties\":{\"hourlySchedule\":{\"snapshotsToKeep\":1763110580,\"minute\":1374695683,\"usedBytes\":8248669428764587059},\"dailySchedule\":{\"snapshotsToKeep\":2084257328,\"hour\":618500847,\"minute\":1570149623,\"usedBytes\":3500912749026197727},\"weeklySchedule\":{\"snapshotsToKeep\":602295715,\"day\":\"geuaulx\",\"hour\":783935050,\"minute\":1584096460,\"usedBytes\":1025453690932299158},\"monthlySchedule\":{\"snapshotsToKeep\":1476296254,\"daysOfMonth\":\"nenlsvxeizzg\",\"hour\":1958797848,\"minute\":2086736187,\"usedBytes\":4209661666295596661},\"enabled\":true,\"provisioningState\":\"cxcktpi\"},\"location\":\"erteeammxqiekk\",\"tags\":{\"mxvavrefdee\":\"drtkgdoj\",\"xs\":\"vecuijpx\",\"wsawddjibabxvi\":\"wprtu\"},\"id\":\"itvtzeexavo\",\"name\":\"tfgle\",\"type\":\"dmdqb\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito
            .when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito
            .when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito
            .when(httpClient.send(httpRequest.capture(), Mockito.any()))
            .thenReturn(
                Mono
                    .defer(
                        () -> {
                            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
                            return Mono.just(httpResponse);
                        }));

        NetAppFilesManager manager =
            NetAppFilesManager
                .configure()
                .withHttpClient(httpClient)
                .authenticate(
                    tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                    new AzureProfile("", "", AzureEnvironment.AZURE));

        SnapshotPolicy response =
            manager
                .snapshotPolicies()
                .define("xxrtikvc")
                .withRegion("cansymoyqhlwigd")
                .withExistingNetAppAccount("zdzgtilaxhnfhqly", "ijouwivkxoyzunb")
                .withTags(mapOf("ajuwas", "kbxgom", "hzbezkgi", "vdaeyyguxakjsq", "vvjskgfmocwahp", "sidxasicdd"))
                .withHourlySchedule(
                    new HourlySchedule()
                        .withSnapshotsToKeep(916087616)
                        .withMinute(1269366447)
                        .withUsedBytes(1943698242721661529L))
                .withDailySchedule(
                    new DailySchedule()
                        .withSnapshotsToKeep(27132642)
                        .withHour(1600333305)
                        .withMinute(1221530840)
                        .withUsedBytes(5358862832851160047L))
                .withWeeklySchedule(
                    new WeeklySchedule()
                        .withSnapshotsToKeep(898501663)
                        .withDay("qskaw")
                        .withHour(1561642293)
                        .withMinute(793073079)
                        .withUsedBytes(4618566353209491802L))
                .withMonthlySchedule(
                    new MonthlySchedule()
                        .withSnapshotsToKeep(483847293)
                        .withDaysOfMonth("tqlkz")
                        .withHour(910896257)
                        .withMinute(1366992874)
                        .withUsedBytes(3840225965423705629L))
                .withEnabled(false)
                .create();

        Assertions.assertEquals("erteeammxqiekk", response.location());
        Assertions.assertEquals("drtkgdoj", response.tags().get("mxvavrefdee"));
        Assertions.assertEquals(1763110580, response.hourlySchedule().snapshotsToKeep());
        Assertions.assertEquals(1374695683, response.hourlySchedule().minute());
        Assertions.assertEquals(8248669428764587059L, response.hourlySchedule().usedBytes());
        Assertions.assertEquals(2084257328, response.dailySchedule().snapshotsToKeep());
        Assertions.assertEquals(618500847, response.dailySchedule().hour());
        Assertions.assertEquals(1570149623, response.dailySchedule().minute());
        Assertions.assertEquals(3500912749026197727L, response.dailySchedule().usedBytes());
        Assertions.assertEquals(602295715, response.weeklySchedule().snapshotsToKeep());
        Assertions.assertEquals("geuaulx", response.weeklySchedule().day());
        Assertions.assertEquals(783935050, response.weeklySchedule().hour());
        Assertions.assertEquals(1584096460, response.weeklySchedule().minute());
        Assertions.assertEquals(1025453690932299158L, response.weeklySchedule().usedBytes());
        Assertions.assertEquals(1476296254, response.monthlySchedule().snapshotsToKeep());
        Assertions.assertEquals("nenlsvxeizzg", response.monthlySchedule().daysOfMonth());
        Assertions.assertEquals(1958797848, response.monthlySchedule().hour());
        Assertions.assertEquals(2086736187, response.monthlySchedule().minute());
        Assertions.assertEquals(4209661666295596661L, response.monthlySchedule().usedBytes());
        Assertions.assertEquals(true, response.enabled());
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
